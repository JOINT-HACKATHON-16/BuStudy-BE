package com.example.hackaton16.domain.bus.presentation.dto.request

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class GenerateEstimatedTimeRequest(
    @field:NotNull(message = "sx(경도)는 필수 값입니다.")
    @field:DecimalMin(value = "-180.0", message = "sx(경도)는 -180 이상이어야 합니다.")
    @field:DecimalMax(value = "180.0", message = "sx(경도)는 180 이하여야 합니다.")
    val sx: Double,

    @field:NotNull(message = "sy(위도)는 필수 값입니다.")
    @field:DecimalMin(value = "-90.0", message = "sy(위도)는 -90 이상이어야 합니다.")
    @field:DecimalMax(value = "90.0", message = "sy(위도)는 90 이하여야 합니다.")
    val sy: Double,

    @field:NotBlank(message = "도로명 주소는 필수 값입니다.")
    @field:Size(max = 255, message = "도로명 주소는 255자 이하로 입력해주세요.")
    val streetAddress: String
)