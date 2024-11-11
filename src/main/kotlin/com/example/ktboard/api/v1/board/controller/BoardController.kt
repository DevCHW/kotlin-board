package com.example.ktboard.api.v1.board.controller

import com.example.ktboard.api.v1.board.controller.dto.request.CreateBoardRequest
import com.example.ktboard.api.v1.board.controller.dto.response.BoardResponse
import com.example.ktboard.api.v1.board.controller.dto.response.CreateBoardResponse
import com.example.ktboard.domain.board.BoardService
import com.example.ktboard.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    val boardService: BoardService,
) {

    /**
     * 게시글 생성
     */
    @PostMapping("/api/v1/boards")
    fun createBoard(
        @RequestBody request: CreateBoardRequest,
    ): ApiResponse<CreateBoardResponse> {
        val result = boardService.create(request.toModel());
        return ApiResponse.success(CreateBoardResponse.from(result))
    }

    /**
     * 게시글 단건 조회
     */
    @GetMapping("/api/v1/boards/{boardId}")
    fun getBoard(
        @PathVariable boardId: Long
    ): ApiResponse<BoardResponse> {
        val result = boardService.findById(boardId)
        return ApiResponse.success(BoardResponse.from(result))
    }
}