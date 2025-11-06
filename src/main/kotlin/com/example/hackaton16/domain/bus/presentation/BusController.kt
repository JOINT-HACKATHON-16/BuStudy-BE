package com.example.hackaton16.domain.bus.presentation

import com.example.hackaton16.domain.bus.service.QueryBusStopListService
import com.example.hackaton16.global.document.bus.BusApiDocument
import com.example.hackaton16.infrastructure.feign.client.datago.dto.response.BusStopResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bus")
class BusController(
    private val queryBusStopListService: QueryBusStopListService
) : BusApiDocument {

    @GetMapping
    override fun queryBusStopList(
        @RequestParam lat: Double,
        @RequestParam lon: Double
    ): List<BusStopResponse.BusStationItem> {
        return queryBusStopListService.execute(lat, lon)
    }
}