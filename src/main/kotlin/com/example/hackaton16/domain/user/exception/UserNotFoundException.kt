package com.example.hackaton16.domain.user.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object UserNotFoundException : HackatonException(
    ErrorCode.USER_NOT_FOUND,
)