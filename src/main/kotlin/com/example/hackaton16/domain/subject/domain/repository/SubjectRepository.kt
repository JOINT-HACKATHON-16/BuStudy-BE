package com.example.hackaton16.domain.subject.domain.repository

import com.example.hackaton16.domain.subject.domain.Subject
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository : JpaRepository<Subject, Long> {
}