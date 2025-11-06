package com.example.hackaton16.infrastructure.feign.client.subject

import com.example.hackaton16.infrastructure.feign.client.subject.dto.response.RecommendSubjectResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@FeignClient(
    name = "SubjectClient",
    url = "\${app.fast-api.base-url}"
)
interface SubjectClient {
    @PostMapping("/upload")
    fun recommendSubject(@RequestPart("file") file: MultipartFile): RecommendSubjectResponse
}