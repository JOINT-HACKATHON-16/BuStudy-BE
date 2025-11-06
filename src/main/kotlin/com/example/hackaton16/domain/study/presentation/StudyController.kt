package com.example.hackaton16.domain.study.presentation

import com.example.hackaton16.domain.study.presentation.dto.request.StudyRequest
import com.example.hackaton16.domain.study.service.GenerateQuizService
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.GenerateQuizResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/study")
class StudyController(
    private val generateQuizService: GenerateQuizService
) {

    @PostMapping("/{subject-id}")
    fun generateQuiz(
        @PathVariable("subject-id") subjectId: Long,
        @RequestBody request: StudyRequest
    ): GenerateQuizResponse {
        return generateQuizService.execute(subjectId, request)
    }
}