package com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response

data class GenerateQuizResponse(
    val uploadId: String,
    val subject: String,
    val questions: List<QuestionResponse>,
    val totalQuestions: Int
) {
    data class QuestionResponse(
        val question: String,
        val options: List<String>,
        val correctAnswer: String,
        val explanation: String
    )
}
