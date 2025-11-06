package com.example.hackaton16.domain.study.presentation.dto.response

import com.example.hackaton16.domain.study.enum.ContentType

sealed class StudyResponse

data class QuizStudyResponse(
    val contentType: ContentType,
    val uploadId: String,
    val subject: String,
    val questions: List<QuestionResponse>,
    val totalQuestions: Int
) : StudyResponse() {
    data class QuestionResponse(
        val question: String,       // 문제
        val options: List<String>,  // 4지선다
        val correctAnswer: String,  // 정답
        val explanation: String     // 해설
    )
}

data class LectureStudyResponse(
    val contentType: ContentType,
    val lectureId: String
) : StudyResponse()

data class AudioStudyResponse(
    val contentType: ContentType,
    val uploadId: String,
    val subject: String,
    val duration: Int,
    val content: String
) : StudyResponse()