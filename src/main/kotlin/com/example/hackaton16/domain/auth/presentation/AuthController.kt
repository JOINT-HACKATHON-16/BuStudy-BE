package com.example.hackaton16.domain.auth.presentation

import com.example.hackaton16.domain.auth.presentation.dto.request.LoginRequest
import com.example.hackaton16.domain.auth.presentation.dto.request.SignUpRequest
import com.example.hackaton16.domain.auth.service.LoginService
import com.example.hackaton16.domain.auth.service.SignUpService
import com.example.hackaton16.domain.auth.service.TokenRefreshService
import com.example.hackaton16.global.document.auth.AuthApiDocument
import com.example.hackaton16.global.utils.token.dto.TokenResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signUpService: SignUpService,
    private val loginService: LoginService,
    private val tokenRefreshService: TokenRefreshService
) : AuthApiDocument {

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    override fun signUp(@RequestBody @Valid request: SignUpRequest) {
        signUpService.execute(request)
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    override fun login(@RequestBody @Valid request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }

    @PutMapping("/re-issue")
    @ResponseStatus(HttpStatus.OK)
    fun tokenRefresh(@RequestHeader("X-Refresh-Token") refreshToken: String): TokenResponse {
        return tokenRefreshService.execute(refreshToken)
    }
}