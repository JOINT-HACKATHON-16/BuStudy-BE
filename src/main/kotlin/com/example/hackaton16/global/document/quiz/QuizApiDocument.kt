package com.example.hackaton16.global.document.quiz

import com.example.hackaton16.domain.quiz.presentation.dto.request.MarkQuizRequest
import com.example.hackaton16.domain.quiz.presentation.dto.response.MarkQuizResponse
import com.example.hackaton16.global.error.ErrorResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "quiz", description = "퀴즈 API")
interface QuizApiDocument {

    @Operation(summary = "퀴즈 채점")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "퀴즈 채점 성공",
                content = [Content(schema = Schema(implementation = MarkQuizResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "문제를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun markQuiz(@RequestBody request: MarkQuizRequest): MarkQuizResponse
}