package com.example.hackaton16.global.document.subject

import com.example.hackaton16.domain.subject.presentation.dto.response.QuerySubjectListResponse
import com.example.hackaton16.global.error.ErrorResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.multipart.MultipartFile

@Tag(name = "subject", description = "과목 API")
interface SubjectApiDocument {

    @Operation(summary = "과목 등록")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "과목 등록 성공"
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun saveSubject(@RequestPart("image") file: MultipartFile)

    @Operation(summary = "과목 목록 조회")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "과목 목록 조회 성공",
                content = [Content(schema = Schema(implementation = QuerySubjectListResponse::class))]
            )
        ]
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun querySubjectList(): QuerySubjectListResponse
}
