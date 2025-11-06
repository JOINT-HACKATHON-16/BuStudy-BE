package com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class GenerateQuizResponse(
    @JsonProperty("upload_id")
    val uploadId: String,
    val subject: String,
    val questions: List<QuestionResponse>,
    @JsonProperty("total_questions")
    val totalQuestions: Int
) {
    data class QuestionResponse(
        val question: String,
        val options: List<String>,
        @JsonProperty("correct_answer")
        val correctAnswer: String,
        val explanation: String
    )
}
