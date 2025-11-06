package com.example.hackaton16.domain.question.domain.repository

import com.example.hackaton16.domain.question.domain.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {

    fun findByQuestion(question: String): Question?
}