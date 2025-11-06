package com.example.hackaton16.domain.quiz.presentation

import com.example.hackaton16.domain.quiz.presentation.dto.request.MarkQuizRequest
import com.example.hackaton16.domain.quiz.presentation.dto.response.MarkQuizResponse
import com.example.hackaton16.domain.quiz.service.MarkQuizService
import com.example.hackaton16.global.document.quiz.QuizApiDocument
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quiz")
class QuizController(
    private val markQuizService: MarkQuizService
) : QuizApiDocument {

    @PostMapping
    override fun markQuiz(@RequestBody @Valid request: MarkQuizRequest): MarkQuizResponse {
        return markQuizService.execute(request)
    }
}