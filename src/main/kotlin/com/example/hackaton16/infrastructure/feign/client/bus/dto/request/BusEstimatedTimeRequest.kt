package com.example.hackaton16.infrastructure.feign.client.bus.dto.request

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull

data class BusEstimatedTimeRequest(
    @field:NotNull(message = "sx(경도)는 필수 값입니다.")
    @field:DecimalMin(value = "-180.0", message = "sx(경도)는 -180 이상이어야 합니다.")
    @field:DecimalMax(value = "180.0", message = "sx(경도)는 180 이하여야 합니다.")
    val sx: Double,

    @field:NotNull(message = "sy(위도)는 필수 값입니다.")
    @field:DecimalMin(value = "-90.0", message = "sy(위도)는 -90 이상이어야 합니다.")
    @field:DecimalMax(value = "90.0", message = "sy(위도)는 90 이하여야 합니다.")
    val sy: Double,

    @field:NotNull(message = "arrivalX(경도)는 필수 값입니다.")
    @field:DecimalMin(value = "-180.0", message = "arrivalX(경도)는 -180 이상이어야 합니다.")
    @field:DecimalMax(value = "180.0", message = "arrivalX(경도)는 180 이하여야 합니다.")
    val arrivalX: Double,

    @field:NotNull(message = "arrivalY(경도)는 필수 값입니다.")
    @field:DecimalMin(value = "-180.0", message = "arrivalY(경도)는 -180 이상이어야 합니다.")
    @field:DecimalMax(value = "180.0", message = "arrivalY(경도)는 180 이하여야 합니다.")
    val arrivalY: Double
)
