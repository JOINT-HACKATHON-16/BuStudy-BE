package com.example.hackaton16.domain.bus.service

import com.example.hackaton16.infrastructure.feign.client.datago.DataGoClient
import com.example.hackaton16.infrastructure.feign.client.datago.dto.response.BusStationResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class QueryBusStopService(
    private val dataGoClient: DataGoClient
) {

    @Value("\${app.data-go.service-key}")
    lateinit var serviceKey: String

    fun execute(lat: Double, lon: Double): List<BusStationResponse.BusStationItem> {
        val response = dataGoClient.getBusStopList(serviceKey, lat, lon)
        return response.response?.body?.items?.item.orEmpty()
    }
}