package com.example.hackaton16.domain.auth.service

import com.example.hackaton16.global.security.jwt.JwtTokenProvider
import com.example.hackaton16.global.utils.token.dto.TokenResponse
import org.springframework.stereotype.Service

@Service
class TokenRefreshService(
    private val jwtTokenProvider: JwtTokenProvider,
) {

    fun execute(refreshToken: String): TokenResponse {
        val tokenResponse = jwtTokenProvider.reissueToken(refreshToken)
        return TokenResponse(tokenResponse.accessToken, tokenResponse.refreshToken)
    }
}