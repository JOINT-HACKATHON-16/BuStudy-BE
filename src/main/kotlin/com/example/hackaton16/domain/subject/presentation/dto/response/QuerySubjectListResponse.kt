package com.example.hackaton16.domain.subject.presentation.dto.response

data class QuerySubjectListResponse(
    val subjects: List<SubjectDto>
) {
    data class SubjectDto(
        val subjectId: Long,
        val subject: String,
    )
}
