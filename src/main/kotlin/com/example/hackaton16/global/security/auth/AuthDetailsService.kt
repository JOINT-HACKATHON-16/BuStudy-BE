package com.example.hackaton16.global.security.auth

import com.example.hackaton16.domain.user.domain.User
import com.example.hackaton16.domain.user.domain.repository.UserRepository
import com.example.hackaton16.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(loginId: String): UserDetails {
        val user: User? = userRepository.findByLoginId(loginId) ?: throw UserNotFoundException
        return AuthDetails(user!!.loginId)
    }
}