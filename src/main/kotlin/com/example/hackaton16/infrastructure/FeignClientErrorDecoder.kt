package com.example.hackaton16.infrastructure

import com.example.hackaton16.infrastructure.feign.exception.FeignBadRequestException
import com.example.hackaton16.infrastructure.feign.exception.FeignForbiddenException
import com.example.hackaton16.infrastructure.feign.exception.FeignServerError
import com.example.hackaton16.infrastructure.feign.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String?, response: Response?): Exception {
        print("feign error : ${response?.reason()}")
        if (response!!.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                else -> throw FeignServerError
            }
        }
        return FeignException.errorStatus(methodKey, response)
    }
}