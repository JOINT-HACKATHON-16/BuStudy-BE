package com.example.hackaton16.domain.auth.service

import com.example.hackaton16.domain.auth.exception.PasswordMismatchException
import com.example.hackaton16.domain.auth.presentation.dto.request.LoginRequest
import com.example.hackaton16.domain.user.domain.repository.UserRepository
import com.example.hackaton16.domain.user.exception.UserNotFoundException
import com.example.hackaton16.global.security.jwt.JwtTokenProvider
import com.example.hackaton16.global.utils.token.dto.TokenResponse
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {

    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userRepository.findByLoginId(request.loginId)
            ?: throw UserNotFoundException

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchException
        }

        return jwtTokenProvider.generateToken(request.loginId)
    }
}