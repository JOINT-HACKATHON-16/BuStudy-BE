package com.example.hackaton16.domain.quiz.service

import com.example.hackaton16.domain.question.domain.repository.QuestionRepository
import com.example.hackaton16.domain.question.excpetion.QuestionNotFoundException
import com.example.hackaton16.domain.quiz.presentation.dto.request.MarkQuizRequest
import com.example.hackaton16.domain.quiz.presentation.dto.response.MarkQuizResponse
import org.springframework.stereotype.Service

@Service
class MarkQuizService(
    private val questionRepository: QuestionRepository
) {

    fun execute(request: MarkQuizRequest): MarkQuizResponse {
        val question = questionRepository.findByQuestion(request.question)
            ?: throw QuestionNotFoundException

        val isCorrect = request.selectAnswer == question.correctAnswer

        return MarkQuizResponse(
            question = request.question,
            selectAnswer = request.selectAnswer,
            isCorrect = isCorrect,
            correctAnswer = question.correctAnswer,
            explanation = question.explanation
        )
    }
}