package com.example.hackaton16.infrastructure.feign.client.fastapi

import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.request.GenerateQuizRequest
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.AudioResponse
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.GenerateQuizResponse
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.RecommendSubjectResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@FeignClient(
    name = "SubjectClient",
    url = "\${app.fast-api.base-url}"
)
interface FastApiClient {
    @PostMapping("/upload", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun recommendSubject(@RequestPart("file") file: MultipartFile): RecommendSubjectResponse

    @PostMapping("/rag/quiz")
    fun generateQuiz(@RequestBody request: GenerateQuizRequest): GenerateQuizResponse

    @PostMapping("/rag/review/{upload-id}")
    fun generateAudio(@PathVariable("upload-id") uploadId: UUID): AudioResponse
}