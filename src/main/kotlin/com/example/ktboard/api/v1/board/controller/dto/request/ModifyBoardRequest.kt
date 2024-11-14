package com.example.ktboard.api.v1.board.controller.dto.request

import com.example.ktboard.api.v1.board.controller.dto.response.BoardResponse
import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.domain.board.model.ModifyBoard

data class ModifyBoardRequest(
    val title: String,
    val content: String,
) {
    fun toModel(boardId: Long): ModifyBoard {
        return ModifyBoard(
            id = boardId,
            title = title,
            content = content,
        )
    }
}
