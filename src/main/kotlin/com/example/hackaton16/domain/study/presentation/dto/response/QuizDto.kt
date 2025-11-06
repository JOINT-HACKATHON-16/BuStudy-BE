package com.example.hackaton16.domain.study.presentation.dto.response

data class QuizDto(
    val uploadId: String,
    val subject: String,
    val questions: List<QuestionResponse>,
    val totalQuestions: Int
) {
    data class QuestionResponse(
        val question: String,       // 문제
        val options: List<String>,  // 4지선다
        val correctAnswer: String,  // 정답
        val explanation: String     // 해설
    )
}
