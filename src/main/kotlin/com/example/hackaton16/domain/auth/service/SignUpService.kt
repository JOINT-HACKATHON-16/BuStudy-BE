package com.example.hackaton16.domain.auth.service

import com.example.hackaton16.domain.auth.exception.PasswordMismatchException
import com.example.hackaton16.domain.auth.exception.UserAlreadyExistsException
import com.example.hackaton16.domain.auth.presentation.dto.request.SignUpRequest
import com.example.hackaton16.domain.user.domain.User
import com.example.hackaton16.domain.user.domain.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun execute(request: SignUpRequest) {

        if (request.password != request.passwordCheck) {
            throw PasswordMismatchException
        }

        if (userRepository.existsByLoginId(request.loginId)) {
            throw UserAlreadyExistsException
        }

        val user = request.run {
            User(
                loginId = loginId,
                name = request.name,
                password = passwordEncoder.encode(password)
            )
        }

        userRepository.save(user)
    }
}