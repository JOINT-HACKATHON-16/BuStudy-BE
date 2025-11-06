package com.example.hackaton16.global.security.jwt

import com.example.hackaton16.domain.refreshtoken.domain.RefreshToken
import com.example.hackaton16.domain.refreshtoken.domain.repository.RefreshTokenRepository
import com.example.hackaton16.global.exception.ExpiredTokenException
import com.example.hackaton16.global.exception.InvalidTokenException
import com.example.hackaton16.global.security.auth.AuthDetailsService
import com.example.hackaton16.global.utils.token.dto.TokenResponse
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.Base64
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository,
) {
    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
    }

    private val secretKey: Key = try {
        Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtProperties.secretKey))
    } catch (e: IllegalArgumentException) {
        Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray(StandardCharsets.UTF_8))
    }

    fun generateToken(loginId: String): TokenResponse {
        return TokenResponse(
            accessToken = createAccessToken(loginId),
            refreshToken = createRefreshToken(loginId),
        )
    }

    fun createAccessToken(loginId: String): String =
        createToken(loginId, ACCESS_TOKEN, jwtProperties.accessExp)

    fun createRefreshToken(loginId: String): String {
        val refreshToken = createToken(loginId, REFRESH_TOKEN, jwtProperties.refreshExp)
        val refreshTokenEntity =
            RefreshToken(
                id = loginId,
                token = refreshToken,
                ttl = jwtProperties.refreshExp * 1000,
            )

        refreshTokenRepository.save(refreshTokenEntity)
        return refreshToken
    }

    private fun createToken(
        loginId: String,
        jwtType: String,
        exp: Long,
    ): String {
        return Jwts.builder()
            .subject(loginId)
            .claim("typ", jwtType)
            .expiration(Date(System.currentTimeMillis() + exp * 1000))
            .issuedAt(Date())
            .signWith(secretKey)
            .compact()
    }

    fun reissueToken(refreshToken: String): TokenResponse {
        if (!isRefreshToken(refreshToken)) {
            throw InvalidTokenException
        }

        val token = refreshTokenRepository.findByToken(refreshToken)
            ?: throw InvalidTokenException

        val id = token.id
        val tokenResponse = generateToken(id)

        token.update(tokenResponse.refreshToken, jwtProperties.refreshExp)

        return TokenResponse(
            tokenResponse.accessToken,
            tokenResponse.refreshToken
        )
    }

    private fun isRefreshToken(token: String?): Boolean {
        return REFRESH_TOKEN == getClaims(token!!).get("typ", String::class.java)
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val tokenType = claims.get("typ", String::class.java)

        return when (tokenType) {
            ACCESS_TOKEN -> {
                val userDetails = authDetailsService.loadUserByUsername(claims.subject)
                UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
            }
            else -> {
                throw InvalidTokenException
            }
        }
    }

    fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .verifyWith(secretKey as SecretKey)
                .build()
                .parseSignedClaims(token).payload
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException
        } catch (e: Exception) {
            throw InvalidTokenException
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(jwtProperties.header) ?: return null

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)) {
            val token = bearerToken.substring(jwtProperties.prefix.length).trim()
            if (token.isNotEmpty()) return token
        }
        return null
    }
}