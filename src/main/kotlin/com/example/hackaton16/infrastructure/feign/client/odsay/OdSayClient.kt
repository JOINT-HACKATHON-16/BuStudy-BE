package com.example.hackaton16.infrastructure.feign.client.odsay

import com.example.hackaton16.infrastructure.feign.client.odsay.dto.response.OdSayResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "OdSayClient",
    url = "\${app.od-say.base-url}"
)
interface OdSayClient {
    @PostMapping("/searchPubTransPathT")
    fun searchPubTransPathT(
        @RequestParam("apiKey") apiKey: String,
        @RequestParam("SX") sx: Double,
        @RequestParam("SY") sy: Double,
        @RequestParam("EX") ex: Double,
        @RequestParam("EY") ey: Double,
    ): OdSayResponse
}