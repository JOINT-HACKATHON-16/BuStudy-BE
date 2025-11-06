package com.example.hackaton16.global.document.bus

import com.example.hackaton16.global.error.ErrorResponse
import com.example.hackaton16.infrastructure.feign.client.datago.dto.response.BusStopResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestParam

@Tag(name = "bus", description = "버스 API")
interface BusApiDocument {

    @Operation(summary = "주변 정류장 조회")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "주변 정류장 조회 성공",
                content = [Content(schema = Schema(implementation = BusStopResponse.BusStationItem::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "잘못된 요청",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun queryBusStopList(
        @RequestParam lat: Double,
        @RequestParam lon: Double
    ): List<BusStopResponse.BusStationItem>
}
