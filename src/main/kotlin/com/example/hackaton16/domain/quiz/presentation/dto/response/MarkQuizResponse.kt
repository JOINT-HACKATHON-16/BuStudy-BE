package com.example.hackaton16.domain.quiz.presentation.dto.response

data class MarkQuizResponse(
    val question: String,
    val selectAnswer: String,
    val isCorrect: Boolean,
    val correctAnswer: String,
    val explanation: String
)