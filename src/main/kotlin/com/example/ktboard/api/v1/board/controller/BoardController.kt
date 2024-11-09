package com.example.ktboard.api.v1.board.controller

import com.example.ktboard.api.v1.board.controller.dto.request.CreateBoardRequest
import com.example.ktboard.api.v1.board.controller.dto.response.CreateBoardResponse
import com.example.ktboard.domain.board.BoardService
import com.example.ktboard.support.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    val boardService: BoardService,
) {

    @PostMapping("/api/v1/boards")
    fun createBoard(
        @RequestBody request: CreateBoardRequest,
    ): ApiResponse<CreateBoardResponse> {
        val result = boardService.create(request.toModel());
        return ApiResponse.success(result)
    }
}