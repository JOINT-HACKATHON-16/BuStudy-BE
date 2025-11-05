package com.example.hackaton16.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
class JwtProperties(
    val header: String,
    val prefix: String,
    val secretKey: String,
    val accessExp: Long,
    val refreshExp: Long,
)