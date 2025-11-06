package com.example.hackaton16.domain.bus.service

import com.example.hackaton16.domain.bus.presentation.dto.request.GenerateEstimatedTimeRequest
import com.example.hackaton16.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.hackaton16.infrastructure.feign.client.kakao.KakaoClient
import com.example.hackaton16.infrastructure.feign.client.odsay.OdSayClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GenerateEstimatedTimeService(
    private val kakaoClient: KakaoClient,
    private val odSayClient: OdSayClient
) {

    @Value("\${app.kakao-map-api.api-key}")
    lateinit var kakaoApiKey: String

    @Value("\${app.od-say.api-key}")
    lateinit var odSayApiKey: String

    fun execute(request: GenerateEstimatedTimeRequest): GenerateEstimatedTimeResponse {
        val coordinate = kakaoClient.getLocationInfo(
                streetAddress = request.streetAddress,
                kakaoAuthorization =  "KakaoAK $kakaoApiKey"
            ).documents[0].address.let {
                Pair(it.y.toDouble(), it.x.toDouble())
            }

        val arrivalY = coordinate.first
        val arrivalX = coordinate.second

        val estimatedTime = odSayClient.searchPubTransPathT(
            odSayApiKey,
            request.sx,
            request.sy,
            arrivalX,
            arrivalY
        )

        return GenerateEstimatedTimeResponse(estimatedTime.totalTime)
    }
}