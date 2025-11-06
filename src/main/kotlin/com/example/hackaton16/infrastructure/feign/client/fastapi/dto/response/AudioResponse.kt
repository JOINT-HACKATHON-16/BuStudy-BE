package com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AudioResponse(
    @JsonProperty("upload_id")
    val uploadId: String,
    val subject: String,
    val duration: Int,
    val content: String
)
