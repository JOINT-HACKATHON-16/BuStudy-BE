package com.example.hackaton16.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    USER_NOT_FOUND(404, "User Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
}