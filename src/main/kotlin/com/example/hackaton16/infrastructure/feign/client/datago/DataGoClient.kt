package com.example.hackaton16.infrastructure.feign.client.datago

import com.example.hackaton16.infrastructure.feign.client.datago.dto.response.BusStopResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "DataGoClient",
    url = "\${app.data-go.base-url}"
)
interface DataGoClient {
    @GetMapping("/getCrdntPrxmtSttnList")
    fun getBusStopList(
        @RequestParam("serviceKey") serviceKey: String,
        @RequestParam("gpsLati") gpsLati: Double,  // GPS Y좌표
        @RequestParam("gpsLong") gpsLong: Double,  // GPS X좌표
        @RequestParam("_type") type: String? = "json"
    ): BusStopResponse
}