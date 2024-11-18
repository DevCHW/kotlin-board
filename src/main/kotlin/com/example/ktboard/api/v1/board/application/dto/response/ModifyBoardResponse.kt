package com.example.ktboard.api.v1.board.application.dto.response

import com.example.ktboard.domain.board.model.Board
import java.time.LocalDateTime

data class ModifyBoardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun from(board: Board): ModifyBoardResponse {
            return ModifyBoardResponse(
                id = board.id,
                title = board.title,
                content = board.content,
                createdAt = board.createdAt,
                updatedAt = board.updatedAt,
            )
        }
    }

}
