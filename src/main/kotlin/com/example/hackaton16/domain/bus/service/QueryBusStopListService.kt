package com.example.hackaton16.domain.bus.service

import com.example.hackaton16.domain.bus.presentation.dto.response.BusStopListResponse
import com.example.hackaton16.infrastructure.feign.client.datago.DataGoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class QueryBusStopListService(
    private val dataGoClient: DataGoClient
) {

    @Value("\${app.data-go.service-key}")
    lateinit var serviceKey: String

    fun execute(lat: Double, lon: Double): BusStopListResponse {
        val responseList = dataGoClient.getBusStopList(serviceKey, lat, lon)
        return BusStopListResponse(
            responseList.response.body.items.item.map {
                BusStopListResponse.BusStopDto(
                    it.nodeid,
                    it.gpslati,
                    it.gpslong,
                    it.nodenm
                )
            }
        )
    }
}