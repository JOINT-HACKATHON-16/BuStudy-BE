package com.example.hackaton16.domain.question.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "question", nullable = false)
    val question: String,

    @Column(name = "correct_answer", nullable = false)
    val correctAnswer: String,

    @Column(name = "explanation", nullable = false)
    val explanation: String
)