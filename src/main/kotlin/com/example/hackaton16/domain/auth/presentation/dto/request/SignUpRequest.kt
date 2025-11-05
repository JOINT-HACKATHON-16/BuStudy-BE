package com.example.hackaton16.domain.auth.presentation.dto.request

import jakarta.validation.constraints.Pattern

data class SignUpRequest(
    val loginId: String,

    val name: String,

    @field:Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=\\[\\]{}|;:'\\\",.<>/?])[A-Za-z\\d!@#$%^&*()_\\-+=\\[\\]{}|;:'\\\",.<>/?]{8,20}$",
        message = "비밀번호는 영문, 숫자, 특수문자를 포함해 8~20자여야 합니다."
    )
    val password: String,

    val passwordCheck: String
)
