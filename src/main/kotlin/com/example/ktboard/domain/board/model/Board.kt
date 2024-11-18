package com.example.ktboard.domain.board.model

import com.example.ktboard.domain.error.CoreException
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

        fun testObject(
            id: Long = 1L,
            title: String = "게시글 제목",
            content: String = "게시글 내용",
            createdAt: LocalDateTime = LocalDateTime.now(),
            updatedAt: LocalDateTime = LocalDateTime.now(),
        ): Board {
            return Board(
                id = id,
                title = title,
                content = content,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }

}