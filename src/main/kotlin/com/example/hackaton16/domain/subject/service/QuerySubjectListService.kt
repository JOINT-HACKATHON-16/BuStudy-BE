package com.example.hackaton16.domain.subject.service

import com.example.hackaton16.domain.subject.domain.repository.SubjectRepository
import com.example.hackaton16.domain.subject.exception.SubjectNotFoundException
import com.example.hackaton16.domain.subject.presentation.dto.response.QuerySubjectListResponse
import com.example.hackaton16.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuerySubjectListService(
    private val subjectRepository: SubjectRepository,
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): QuerySubjectListResponse {
        val user = userFacade.getCurrentUser()

        val subjects = subjectRepository.findAllByUser(user)
            ?: throw SubjectNotFoundException

        return QuerySubjectListResponse(
            subjects.map { QuerySubjectListResponse.SubjectDto(it.id, it.subject) }
        )
    }
}