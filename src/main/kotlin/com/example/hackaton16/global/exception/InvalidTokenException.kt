package com.example.hackaton16.global.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object InvalidTokenException : HackatonException(
    ErrorCode.INVALID_TOKEN
)