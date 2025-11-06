package com.example.hackaton16.domain.study.presentation.dto.request

import jakarta.validation.constraints.Size

data class StudyRequest(

    @field:Size(min = 1, message = "예상 시간은 최소 1분 이상이여야 합니다.")
    val estimatedTime: Int
)
