package com.example.hackaton16.infrastructure.feign.client.bus

import com.example.hackaton16.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.hackaton16.infrastructure.feign.client.bus.dto.request.BusEstimatedTimeRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    name = "BusClient",
    url = "\${app.serve-server.base-url}"
)
interface BusClient {
    @PostMapping("/bus")
    fun generateEstimatedTime(request: BusEstimatedTimeRequest): GenerateEstimatedTimeResponse
}