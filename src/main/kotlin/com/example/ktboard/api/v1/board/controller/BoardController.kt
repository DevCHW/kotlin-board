package com.example.ktboard.api.v1.board.controller

import com.example.ktboard.api.v1.board.controller.dto.request.CreateBoardRequest
import com.example.ktboard.api.v1.board.controller.dto.request.ModifyBoardRequest
import com.example.ktboard.api.v1.board.controller.dto.response.BoardResponse
import com.example.ktboard.api.v1.board.controller.dto.response.CreateBoardResponse
import com.example.ktboard.domain.board.BoardService
import com.example.ktboard.support.response.ApiResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    private val boardService: BoardService,
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
        val result = boardService.getBoard(boardId)
        return ApiResponse.success(BoardResponse.from(result))
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/api/v1/boards/{boardId}")
    fun deleteBoard(
        @PathVariable boardId: Long,
    ): ApiResponse<Unit> {
        val result = boardService.delete(boardId)
        return ApiResponse.success(Unit)
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/api/v1/boards/{boardId}")
    fun modifyBoard(
        @PathVariable boardId: Long,
        @RequestBody request: ModifyBoardRequest,
    ): ApiResponse<BoardResponse> {
        val result = boardService.modifyBoard(request.toModel(boardId))
        return ApiResponse.success(BoardResponse.from(result))
    }

}