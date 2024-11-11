package com.example.ktboard.api.v1.board.controller.dto.response

import com.example.ktboard.domain.board.model.Board
import java.time.LocalDateTime

data class BoardResponse private constructor(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun from(board: Board): BoardResponse {
            return BoardResponse(
                id = board.id,
                title = board.title,
                content = board.content,
                createdAt = board.createdAt,
                updatedAt = board.updatedAt,
            )
        }
    }
}
