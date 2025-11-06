package com.example.hackaton16.domain.subject.service

import com.example.hackaton16.domain.subject.domain.Subject
import com.example.hackaton16.domain.subject.domain.repository.SubjectRepository
import com.example.hackaton16.domain.subject.presentation.dto.response.SaveSubjectResponse
import com.example.hackaton16.domain.user.facade.UserFacade
import com.example.hackaton16.infrastructure.feign.client.fastapi.FastApiClient
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@Service
class SaveSubjectService(
    private val subjectRepository: SubjectRepository,
    private val fastApiClient: FastApiClient,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(file: MultipartFile): SaveSubjectResponse {
        val user = userFacade.getCurrentUser()
        val recommendSubjectResponse = fastApiClient.recommendSubject(file)

        subjectRepository.save(
            Subject(
                user = user,
                subject = recommendSubjectResponse.subject,
                uploadId = UUID.fromString(recommendSubjectResponse.uploadId)
            )
        )

        return SaveSubjectResponse(recommendSubjectResponse.subject)
    }
}