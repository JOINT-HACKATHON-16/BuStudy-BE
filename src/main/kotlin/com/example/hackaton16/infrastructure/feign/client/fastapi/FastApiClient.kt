package com.example.hackaton16.infrastructure.feign.client.fastapi

import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.RecommendSubjectResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@FeignClient(
    name = "SubjectClient",
    url = "\${app.fast-api.base-url}"
)
interface FastApiClient {
    @PostMapping("/upload", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun recommendSubject(@RequestPart("file") file: MultipartFile): RecommendSubjectResponse
}