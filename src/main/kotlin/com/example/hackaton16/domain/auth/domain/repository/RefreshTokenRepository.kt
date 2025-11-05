package com.example.hackaton16.domain.auth.domain.repository

import com.example.hackaton16.domain.auth.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
}