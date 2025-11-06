package com.example.hackaton16.domain.bus.service

import com.example.hackaton16.domain.bus.presentation.dto.request.GenerateEstimatedTimeRequest
import com.example.hackaton16.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.hackaton16.infrastructure.feign.client.bus.BusClient
import com.example.hackaton16.infrastructure.feign.client.bus.dto.request.BusEstimatedTimeRequest
import com.example.hackaton16.infrastructure.feign.client.kakao.KakaoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GenerateEstimatedTimeService(
    private val kakaoClient: KakaoClient,
    private val busClient: BusClient
) {

    @Value("\${app.kakao-map-api.api-key}")
    lateinit var kakaoApiKey: String

    fun execute(request: GenerateEstimatedTimeRequest): GenerateEstimatedTimeResponse {
        val coordinate = kakaoClient.getLocationInfo(
                streetAddress = request.streetAddress,
                kakaoAuthorization =  "KakaoAK $kakaoApiKey"
            ).documents[0].address.let {
                Pair(it.y.toDouble(), it.x.toDouble())
            }

        val arrivalY = coordinate.first
        val arrivalX = coordinate.second

        val generateEstimatedTimeResponse = busClient.generateEstimatedTime(
            BusEstimatedTimeRequest(
                request.sx,
                request.sy,
                arrivalX,
                arrivalY
            )
        )

        return GenerateEstimatedTimeResponse(generateEstimatedTimeResponse.estimatedTime)
    }
}