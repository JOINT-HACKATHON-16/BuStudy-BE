package com.example.hackaton16.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tbl_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(name = "login_id", nullable = false, unique = true)
    private val loginId: String,

    @Column(name = "name", nullable = false)
    private val name: String,

    @Column(name = "password", nullable = false)
    private val password: String
)