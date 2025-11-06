package com.example.hackaton16.domain.study.presentation

import com.example.hackaton16.domain.study.presentation.dto.request.StudyRequest
import com.example.hackaton16.domain.study.presentation.dto.response.StudyResponse
import com.example.hackaton16.domain.study.service.StartStudyService
import com.example.hackaton16.global.document.study.StudyApiDocument
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/study")
class StudyController(
    private val startStudyService: StartStudyService,
) : StudyApiDocument {

    @PostMapping("/{subject-id}")
    override fun generateStudyContent(
        @PathVariable("subject-id") subjectId: Long,
        @RequestBody @Valid request: StudyRequest
    ): StudyResponse {
        return startStudyService.execute(subjectId, request)
    }
}