package com.example.ktboard.api.v1.board.application.dto.response

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

        fun fixture(
            id: Long = 1L,
            title: String = "title",
            content: String = "content",
            createdAt: LocalDateTime = LocalDateTime.now(),
            updatedAt: LocalDateTime = LocalDateTime.now(),
        ): BoardResponse {
            return BoardResponse(
                id = id,
                title = title,
                content = content,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }
}
