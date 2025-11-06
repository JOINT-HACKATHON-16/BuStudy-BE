package com.example.hackaton16.domain.subject.domain.repository

import com.example.hackaton16.domain.subject.domain.Subject
import com.example.hackaton16.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository : JpaRepository<Subject, Long> {

    fun findAllByUser(user: User): List<Subject>?

    fun findSubjectById(subjectId: Long): Subject?
}