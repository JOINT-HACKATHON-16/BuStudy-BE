package com.example.hackaton16.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    FEIGN_UNAUTHORIZED(401, "Feign UnAuthorized"),
    FEIGN_FORBIDDEN(403, "Feign Forbidden"),
    FEIGN_SERVER_ERROR(500, "Feign Server Error"),

    PASSWORD_MISMATCH(400, "비밀번호가 일치하지 않습니다."),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),
    SUBJECT_NOT_FOUND(404, "Subject Not Found"),
    QUESTION_NOT_FOUND(404, "Question Not Found"),
    ALREADY_EXISTS_USER_ID(409, "이미 존재하는 아이디입니다."),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
}