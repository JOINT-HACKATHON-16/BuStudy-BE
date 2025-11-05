package com.example.hackaton16.domain.refreshtoken.domain

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    @Id
    val id: String,

    @Indexed
    var token: String,

    @TimeToLive
    var ttl: Long
)