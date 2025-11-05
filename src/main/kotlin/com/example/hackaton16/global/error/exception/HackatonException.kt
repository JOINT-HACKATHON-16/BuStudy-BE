package com.example.hackaton16.global.error.exception

abstract class HackatonException(
    val errorCode: ErrorCode
) : RuntimeException()