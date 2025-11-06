package com.example.hackaton16.domain.subject.exception

import com.example.hackaton16.global.error.exception.ErrorCode
import com.example.hackaton16.global.error.exception.HackatonException

object SubjectNotFoundException : HackatonException(
    ErrorCode.SUBJECT_NOT_FOUND
)