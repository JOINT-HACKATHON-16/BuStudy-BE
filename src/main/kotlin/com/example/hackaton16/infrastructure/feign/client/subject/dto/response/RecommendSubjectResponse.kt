package com.example.hackaton16.infrastructure.feign.client.subject.dto.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class RecommendSubjectResponse(
    val subject: String,

    @JsonProperty("upload_id")
    val uploadId: String
)
