package com.example.hackaton16.infrastructure.feign.client.datago.dto.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BusStopResponse(
    val response: BusResponseWrapper?
) {
    data class BusResponseWrapper(
        val body: BusResponseBody?
    )

    data class BusResponseBody(
        val items: BusResponseItems?,
        val numOfRows: Int?,
        val pageNo: Int?,
        val totalCount: Int?
    )

    data class BusResponseItems(
        val item: List<BusStationItem>?
    )

    data class BusStationItem(
        val nodeid: String?,
        val gpslati: Double?,
        val gpslong: Double?,
        val nodenm: String?,
    )
}
