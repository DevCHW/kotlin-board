package com.example.ktboard.domain.board

import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.domain.board.model.CreateBoard
import com.example.ktboard.domain.board.model.ModifyBoard

interface BoardRepository {
    fun findById(id: Long): Board

    fun save(createBoard: CreateBoard): Board

    fun update(modifyBoard: ModifyBoard): Board

    fun findByIdOrNull(id: Long): Board?

    fun delete(id: Long)
}