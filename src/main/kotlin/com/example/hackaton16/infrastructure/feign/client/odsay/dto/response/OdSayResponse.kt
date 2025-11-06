package com.example.hackaton16.infrastructure.feign.client.odsay.dto.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OdSayResponse(
    val totalTime: Int
)
