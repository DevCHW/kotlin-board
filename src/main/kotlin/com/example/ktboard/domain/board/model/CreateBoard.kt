package com.example.ktboard.domain.board.model

data class CreateBoard(
    val userId: Long,
    val title: String,
    val content: String,
)
