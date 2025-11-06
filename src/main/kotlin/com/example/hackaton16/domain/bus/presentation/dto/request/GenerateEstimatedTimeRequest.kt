package com.example.hackaton16.domain.bus.presentation.dto.request

data class GenerateEstimatedTimeRequest(
    val sx: Double,
    val sy: Double,
    val streetAddress: String
)