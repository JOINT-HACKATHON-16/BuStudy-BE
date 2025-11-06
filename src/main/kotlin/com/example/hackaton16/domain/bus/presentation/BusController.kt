package com.example.hackaton16.domain.bus.presentation

import com.example.hackaton16.domain.bus.presentation.dto.request.GenerateEstimatedTimeRequest
import com.example.hackaton16.domain.bus.presentation.dto.response.BusStopListResponse
import com.example.hackaton16.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.hackaton16.domain.bus.service.GenerateEstimatedTimeService
import com.example.hackaton16.domain.bus.service.QueryBusStopListService
import com.example.hackaton16.global.document.bus.BusApiDocument
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bus")
class BusController(
    private val queryBusStopListService: QueryBusStopListService,
    private val generateEstimatedTimeService: GenerateEstimatedTimeService
) : BusApiDocument {

    @GetMapping
    override fun queryBusStopList(
        @RequestParam lat: Double,
        @RequestParam lon: Double
    ): BusStopListResponse {
        return queryBusStopListService.execute(lat, lon)
    }

    @PostMapping
    override fun generateEstimatedTime(@RequestBody @Valid request: GenerateEstimatedTimeRequest): GenerateEstimatedTimeResponse {
        return generateEstimatedTimeService.execute(request)
    }
}