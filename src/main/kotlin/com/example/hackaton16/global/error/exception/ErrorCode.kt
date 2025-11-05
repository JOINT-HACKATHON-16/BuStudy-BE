package com.example.hackaton16.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
}