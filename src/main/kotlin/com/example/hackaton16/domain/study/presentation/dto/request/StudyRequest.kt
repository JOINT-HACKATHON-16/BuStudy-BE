package com.example.hackaton16.domain.study.presentation.dto.request

import jakarta.validation.constraints.NotNull

data class StudyRequest(

    @field:NotNull(message = "예상 시간은 null일 수 없습니다.")
    val estimatedTime: Int
)
