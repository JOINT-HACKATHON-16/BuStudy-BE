package com.example.hackaton16.domain.refreshtoken.domain.repository

import com.example.hackaton16.domain.refreshtoken.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {

    fun findByToken(refreshToken: String): RefreshToken?
}