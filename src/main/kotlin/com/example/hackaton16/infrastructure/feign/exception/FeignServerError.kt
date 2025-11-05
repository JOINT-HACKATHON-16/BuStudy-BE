package com.example.hackaton16.infrastructure.feign.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object FeignServerError : HackatonException(
    ErrorCode.FEIGN_SERVER_ERROR
)