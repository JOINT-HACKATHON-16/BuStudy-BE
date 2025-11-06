package com.example.hackaton16.infrastructure.feign.client.datago.dto.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BusStopResponse(
    val response: Response
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Response(
        val header: Header?,
        val body: Body
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Header(
        val resultCode: String,
        val resultMsg: String
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Body(
        val numOfRows: Int,
        val pageNo: Int,
        val totalCount: Int,
        val items: Items
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Items(
        val item: List<BusStopItem>
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class BusStopItem(
        val gpslati: Double,   // 위도
        val gpslong: Double,   // 경도
        val nodeid: String,    // 정류소 ID
        val nodenm: String,    // 정류소명
        val citycode: String   // 도시코드
    )
}
