package com.example.ktboard.storage.entity

import jakarta.persistence.*

@Entity
@Table(name = "board")
class BoardEntity(

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String
) : BaseEntity()