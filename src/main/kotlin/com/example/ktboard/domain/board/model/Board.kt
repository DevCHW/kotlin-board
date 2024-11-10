package com.example.ktboard.domain.board.model

import com.example.ktboard.storage.core.entity.BoardEntity
import java.time.LocalDateTime

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun of(boardEntity: BoardEntity): Board {
            return Board(
                id = boardEntity.id,
                title = boardEntity.title,
                content = boardEntity.content,
                createdAt = boardEntity.createdAt,
                updatedAt = boardEntity.updatedAt,
            )
        }
    }
}