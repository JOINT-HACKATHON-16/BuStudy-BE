package com.example.hackaton16.domain.quiz.presentation

import com.example.hackaton16.domain.quiz.presentation.dto.request.MarkQuizRequest
import com.example.hackaton16.domain.quiz.presentation.dto.response.MarkQuizResponse
import com.example.hackaton16.domain.quiz.service.MarkQuizService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quiz")
class QuizController(
    private val markQuizService: MarkQuizService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun markQuiz(@RequestBody @Valid request: MarkQuizRequest): MarkQuizResponse {
        return markQuizService.execute(request)
    }
}