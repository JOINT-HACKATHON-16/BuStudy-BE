package com.example.hackaton16.domain.question.excpetion

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object QuestionNotFoundException : HackatonException(
    ErrorCode.QUESTION_NOT_FOUND
)