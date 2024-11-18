package com.example.ktboard.api.v1.board.application

import com.example.ktboard.api.v1.board.application.dto.request.CreateBoardRequest
import com.example.ktboard.api.v1.board.application.dto.request.ModifyBoardRequest
import com.example.ktboard.api.v1.board.application.dto.response.BoardResponse
import com.example.ktboard.api.v1.board.application.dto.response.CreateBoardResponse
import com.example.ktboard.api.v1.board.application.dto.response.ModifyBoardResponse
import com.example.ktboard.domain.board.BoardService
import org.springframework.stereotype.Component

@Component
class BoardFacade(
    private val boardService: BoardService
) {
    fun create(request: CreateBoardRequest): CreateBoardResponse {
        val createdBoard = boardService.create(request.toModel())
        return CreateBoardResponse.from(createdBoard)
    }

    fun getBoard(id: Long): BoardResponse {
        return BoardResponse.from(boardService.getBoard(id))
    }

    fun getBoards(): List<BoardResponse> {
        return boardService.getBoards().map { BoardResponse.from(it) }
    }

    fun modifyBoard(id: Long, request: ModifyBoardRequest): ModifyBoardResponse {
        val modifiedBoard = boardService.modifyBoard(request.toModel(boardId = id))
        return ModifyBoardResponse.from(modifiedBoard)
    }

    fun delete(boardId: Long) {
        boardService.delete(boardId)
    }

}