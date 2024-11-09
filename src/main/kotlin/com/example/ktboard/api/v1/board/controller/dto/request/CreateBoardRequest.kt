package com.example.ktboard.api.v1.board.controller.dto.request

import com.example.ktboard.domain.board.model.CreateBoard

data class CreateBoardRequest(
    val title: String,
    val content: String,
) {
    fun toModel(): CreateBoard {
        return CreateBoard(
            title = this.title,
            content = this.content,
        )
    }
}
