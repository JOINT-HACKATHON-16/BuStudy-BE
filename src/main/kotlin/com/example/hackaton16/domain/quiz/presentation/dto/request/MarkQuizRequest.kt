package com.example.hackaton16.domain.quiz.presentation.dto.request

import jakarta.validation.constraints.NotNull

data class MarkQuizRequest(

    @field:NotNull(message = "문제는 필수 입력입니다.")
    val question: String,

    @field:NotNull(message = "선택한 답변은 필수 입력입니다.")
    val selectAnswer: String
)
