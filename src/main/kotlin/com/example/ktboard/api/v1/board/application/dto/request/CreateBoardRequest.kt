package com.example.ktboard.api.v1.board.application.dto.request

import com.example.ktboard.domain.board.model.CreateBoard

data class CreateBoardRequest private constructor(
    val userId: Long,
    val title: String,
    val content: String,
) {
    fun toModel(): CreateBoard {
        return CreateBoard(
            userId = this.userId,
            title = this.title,
            content = this.content,
        )
    }

}
