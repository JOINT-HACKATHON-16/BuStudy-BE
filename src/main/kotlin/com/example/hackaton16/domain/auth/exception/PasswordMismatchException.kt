package com.example.hackaton16.domain.auth.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object PasswordMismatchException : HackatonException(
    ErrorCode.PASSWORD_MISMATCH
)