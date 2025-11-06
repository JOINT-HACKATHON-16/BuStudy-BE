package com.example.hackaton16.domain.study.service

import com.example.hackaton16.domain.study.presentation.dto.request.StudyRequest
import com.example.hackaton16.domain.subject.domain.repository.SubjectRepository
import com.example.hackaton16.domain.subject.exception.SubjectNotFoundException
import com.example.hackaton16.infrastructure.feign.client.fastapi.FastApiClient
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.request.GenerateQuizRequest
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.response.GenerateQuizResponse
import org.springframework.stereotype.Service

@Service
class GenerateQuizService(
    private val fastApiClient: FastApiClient,
    private val subjectRepository: SubjectRepository
) {

    fun execute(subjectId: Long, request: StudyRequest): GenerateQuizResponse {
        val subject = subjectRepository.findSubjectById(subjectId)
            ?: throw SubjectNotFoundException

        return fastApiClient.generateQuiz(
            GenerateQuizRequest(
                subject.uploadId,
                request.numQuestions,
                request.difficulty
            )
        )
    }
}