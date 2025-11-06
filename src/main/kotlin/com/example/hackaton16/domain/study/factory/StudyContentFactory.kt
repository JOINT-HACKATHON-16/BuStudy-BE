package com.example.hackaton16.domain.study.factory

import com.example.hackaton16.domain.study.enum.ContentType
import org.springframework.stereotype.Component

@Component
class StudyContentFactory {
    fun generateStudyContent(estimatedTime: Int): ContentType {
        return when {
            estimatedTime <= 5 -> ContentType.AUDIO
            estimatedTime <= 20 -> ContentType.QUIZ
            else -> ContentType.LECTURE
        }
    }
}