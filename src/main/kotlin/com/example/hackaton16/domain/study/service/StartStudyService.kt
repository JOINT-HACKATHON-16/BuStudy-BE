package com.example.hackaton16.domain.study.service

import com.example.hackaton16.domain.study.enum.ContentType
import com.example.hackaton16.domain.study.factory.StudyContentFactory
import com.example.hackaton16.domain.study.presentation.dto.request.StudyRequest
import com.example.hackaton16.domain.study.presentation.dto.response.AudioStudyResponse
import com.example.hackaton16.domain.study.presentation.dto.response.LectureStudyResponse
import com.example.hackaton16.domain.study.presentation.dto.response.QuizStudyResponse
import com.example.hackaton16.domain.study.presentation.dto.response.QuizStudyResponse.QuestionResponse
import com.example.hackaton16.domain.study.presentation.dto.response.StudyResponse
import com.example.hackaton16.domain.subject.domain.repository.SubjectRepository
import com.example.hackaton16.domain.subject.exception.SubjectNotFoundException
import com.example.hackaton16.infrastructure.feign.client.fastapi.FastApiClient
import com.example.hackaton16.infrastructure.feign.client.fastapi.dto.request.GenerateQuizRequest
import org.springframework.stereotype.Service

@Service
class StartStudyService(
    private val fastApiClient: FastApiClient,
    private val subjectRepository: SubjectRepository,
    private val studyContentFactory: StudyContentFactory
) {

    companion object {
        private const val DIFFICULTY = "medium"
        private const val QUESTION_QUANTITY = 1
    }

    fun execute(subjectId: Long, request: StudyRequest): StudyResponse {
        val subject = subjectRepository.findSubjectById(subjectId)
            ?: throw SubjectNotFoundException

        val contentType = studyContentFactory.generateStudyContent(request.estimatedTime)

        return when (contentType) {
            ContentType.QUIZ -> {
                val quiz = fastApiClient.generateQuiz(
                    GenerateQuizRequest(subject.uploadId, QUESTION_QUANTITY, DIFFICULTY)
                )

                QuizStudyResponse(
                    contentType = ContentType.QUIZ,
                    uploadId = quiz.uploadId,
                    subject = quiz.subject,
                    questions = quiz.questions.map {
                        QuestionResponse(
                            it.question,
                            it.options,
                            it.correctAnswer,
                            it.explanation
                        )
                    },
                    totalQuestions = quiz.totalQuestions
                )
            }

            ContentType.AUDIO -> {
                val audioResponse = fastApiClient.generateAudio(subject.uploadId)

                AudioStudyResponse(
                    ContentType.AUDIO,
                    audioResponse.uploadId,
                    audioResponse.subject,
                    audioResponse.duration,
                    audioResponse.content
                )
            }

            ContentType.LECTURE -> {
                val lectureId = "-HtsNI3Jd2A"
                LectureStudyResponse(ContentType.LECTURE, lectureId)
            }

        }
    }
}