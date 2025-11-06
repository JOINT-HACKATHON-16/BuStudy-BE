package com.example.hackaton16.global.document.study

import com.example.hackaton16.domain.study.presentation.dto.request.StudyRequest
import com.example.hackaton16.global.error.ErrorResponse
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.GenerateQuizResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "study", description = "학습 API")
interface StudyApiDocument {

    @Operation(summary = "퀴즈 생성")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "퀴즈 생성 성공",
                content = [Content(schema = Schema(implementation = GenerateQuizResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "과목을 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun generateQuiz(
        @PathVariable("subject-id") subjectId: Long,
        @RequestBody request: StudyRequest
    ): GenerateQuizResponse
}
