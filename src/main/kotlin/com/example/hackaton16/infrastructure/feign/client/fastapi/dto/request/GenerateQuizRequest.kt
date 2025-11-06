package com.example.hackaton16.infrastructure.feign.client.fastapi.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class GenerateQuizRequest(
    val uploadId: UUID,

    @JsonProperty("num_questions")
    val numQuestions: Int,

    val difficulty: String
)
