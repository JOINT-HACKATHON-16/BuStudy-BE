package com.example.hackaton16.domain.auth.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class SignUpRequest(

    @field:NotBlank(message = "아이디는 필수 입력입니다.")
    val loginId: String,

    @field:NotBlank(message = "이름은 필수 입력입니다.")
    val name: String,

    @field:NotBlank(message = "비밀번호는 필수 입력입니다.")
    @field:Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=\\[\\]{}|;:'\\\",.<>/?])[A-Za-z\\d!@#$%^&*()_\\-+=\\[\\]{}|;:'\\\",.<>/?]{8,20}$",
        message = "비밀번호는 영문, 숫자, 특수문자를 포함해 8~20자여야 합니다."
    )
    val password: String,

    @field:NotBlank(message = "비밀번호 확인은 필수 입력입니다.")
    val passwordCheck: String
)
