package com.example.ktboard.domain.board

import com.example.ktboard.api.v1.board.controller.dto.response.CreateBoardResponse
import com.example.ktboard.domain.board.model.CreateBoard
import org.springframework.stereotype.Service

@Service
class BoardService {
    fun create(toModel: CreateBoard): CreateBoardResponse {
        TODO("Not yet implemented")
    }
}