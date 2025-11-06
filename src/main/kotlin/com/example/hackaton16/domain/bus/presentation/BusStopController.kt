package com.example.hackaton16.domain.bus.presentation

import com.example.hackaton16.domain.bus.service.QueryBusStopService
import com.example.hackaton16.infrastructure.feign.client.datago.dto.response.BusStationResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bus")
class BusStopController(
    private val queryBusStopService: QueryBusStopService
) {

    @GetMapping
    fun queryBusStopList(
        @RequestParam lat: Double,
        @RequestParam lon: Double
    ): List<BusStationResponse.BusStationItem> {
        return queryBusStopService.execute(lat, lon)
    }
}