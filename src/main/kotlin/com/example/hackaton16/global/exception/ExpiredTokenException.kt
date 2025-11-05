package com.example.hackaton16.global.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object ExpiredTokenException : HackatonException(
    ErrorCode.EXPIRED_TOKEN
)