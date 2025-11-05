package com.example.hackaton16.domain.user.facade

import com.example.hackaton16.domain.user.domain.User
import com.example.hackaton16.domain.user.domain.repository.UserRepository
import com.example.hackaton16.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val loginId = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByLoginId(loginId) ?: throw UserNotFoundException
    }
}