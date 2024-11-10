package com.example.ktboard.domain.board

import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.domain.board.model.CreateBoard
import com.example.ktboard.domain.error.CoreException
import com.example.ktboard.domain.error.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    val boardRepository: BoardRepository
) {
    @Transactional
    fun create(createBoard: CreateBoard): Board {
        return boardRepository.save(createBoard)
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Board {
        return boardRepository.findByIdOrNull(id)?: throw CoreException(ErrorType.DEFAULT_SERVER_ERROR)
    }

    @Transactional
    fun delete(id: Long) {
        boardRepository.delete(id)
    }


}