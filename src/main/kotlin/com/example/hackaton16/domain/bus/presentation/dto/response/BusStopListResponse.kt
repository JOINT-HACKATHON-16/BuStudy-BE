package com.example.hackaton16.domain.bus.presentation.dto.response

data class BusStopListResponse(
    val busStops: List<BusStopDto>
) {
    data class BusStopDto(
        val nodeid: String,
        val gpslati: Double,
        val gpslong: Double,
        val nodenm: String
    )
}