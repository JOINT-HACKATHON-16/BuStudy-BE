package com.example.hackaton16.infrastructure.feign.client.kakao

import com.example.hackaton16.infrastructure.feign.client.kakao.dto.response.LocationElement
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "KakaoClient",
    url = "\${app.kakao-map-api.base-url}",
)
interface KakaoClient {

    // 도로명 주소를 통해 위도 경도 추출
    @GetMapping("/v2/local/search/address.json")
    fun getLocationInfo(
        @RequestParam("query") streetAddress: String,
        @RequestHeader("Authorization") kakaoAuthorization: String
    ): LocationElement
}