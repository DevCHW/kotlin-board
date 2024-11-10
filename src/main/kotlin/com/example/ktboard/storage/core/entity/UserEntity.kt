package com.example.ktboard.storage.core.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(

    @Column(name = "name")
    val name: String,

    @Column(name = "age")
    val age: Int,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String
) : BaseEntity()