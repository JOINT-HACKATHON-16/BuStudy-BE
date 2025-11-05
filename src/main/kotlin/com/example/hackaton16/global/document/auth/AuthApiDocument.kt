package com.example.hackaton16.global.document.auth

import com.example.hackaton16.domain.auth.presentation.dto.request.LoginRequest
import com.example.hackaton16.domain.auth.presentation.dto.request.SignUpRequest
import com.example.hackaton16.global.error.ErrorResponse
import com.example.hackaton16.global.utils.token.dto.TokenResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus

@Tag(name = "auth", description = "인증 API")
interface AuthApiDocument {

    @Operation(summary = "회원가입")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "회원가입 성공"
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "409",
                description = "유저가 이미 존재함",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody @Valid request: SignUpRequest)

    @Operation(summary = "로그인")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "로그인 성공",
                content = [Content(schema = Schema(implementation = TokenResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "비밀번호가 일치하지 않음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "유저를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody @Valid request: LoginRequest): TokenResponse
}