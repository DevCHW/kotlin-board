package com.example.ktboard.api.v1.board.application.dto.response

import com.example.ktboard.domain.board.model.Board
import java.time.LocalDateTime

data class CreateBoardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun from(board: Board): CreateBoardResponse {
            return CreateBoardResponse(
                id = board.id,
                title = board.title,
                content = board.content,
                createdAt = board.createdAt,
                updatedAt = board.updatedAt,
            )
        }
    }
}
