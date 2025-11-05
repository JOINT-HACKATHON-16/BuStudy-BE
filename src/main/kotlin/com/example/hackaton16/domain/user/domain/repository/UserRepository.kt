package com.example.hackaton16.domain.user.domain.repository

import com.example.hackaton16.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByLoginId(loginId: String): User?
}