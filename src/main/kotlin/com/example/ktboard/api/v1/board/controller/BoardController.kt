package com.example.ktboard.api.v1.board.controller

import com.example.ktboard.api.v1.board.application.BoardFacade
import com.example.ktboard.api.v1.board.application.dto.request.CreateBoardRequest
import com.example.ktboard.api.v1.board.application.dto.request.ModifyBoardRequest
import com.example.ktboard.api.v1.board.application.dto.response.BoardResponse
import com.example.ktboard.api.v1.board.application.dto.response.CreateBoardResponse
import com.example.ktboard.api.v1.board.application.dto.response.ModifyBoardResponse
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
    private val boardFacade: BoardFacade,
) {

    /**
     * 게시글 생성
     */
    @PostMapping("/api/v1/boards")
    fun createBoard(
        @RequestBody request: CreateBoardRequest,
    ): ApiResponse<CreateBoardResponse> {
        val data = boardFacade.create(request)
        return ApiResponse.success(data)
    }

    /**
     * 게시글 단건 조회
     */
    @GetMapping("/api/v1/boards/{boardId}")
    fun getBoard(
        @PathVariable boardId: Long
    ): ApiResponse<BoardResponse> {
        val data = boardFacade.getBoard(boardId)
        return ApiResponse.success(data)
    }

    /**
     * 게시글 목록 조회
     */
    @GetMapping("/api/v1/boards")
    fun getBoards(): ApiResponse<List<BoardResponse>> {
        val data = boardFacade.getBoards()
        return ApiResponse.success(data)
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/api/v1/boards/{boardId}")
    fun deleteBoard(
        @PathVariable boardId: Long,
    ): ApiResponse<Unit> {
        val data = boardFacade.delete(boardId)
        return ApiResponse.success(Unit)
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/api/v1/boards/{boardId}")
    fun modifyBoard(
        @PathVariable boardId: Long,
        @RequestBody request: ModifyBoardRequest,
    ): ApiResponse<ModifyBoardResponse> {
        val data = boardFacade.modifyBoard(boardId, request)
        return ApiResponse.success(data)
    }

}