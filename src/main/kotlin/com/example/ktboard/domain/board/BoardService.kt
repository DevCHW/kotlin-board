package com.example.ktboard.domain.board

import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.domain.board.model.CreateBoard
import com.example.ktboard.domain.board.model.ModifyBoard
import com.example.ktboard.domain.error.CoreException
import com.example.ktboard.domain.error.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {
    @Transactional
    fun create(createBoard: CreateBoard): Board {
        return boardRepository.save(createBoard)
    }

    @Transactional(readOnly = true)
    fun getBoard(id: Long): Board {
        return boardRepository.findByIdOrNull(id)?: throw CoreException(ErrorType.RESOURCE_NOT_FOUND)
    }

    @Transactional
    fun delete(id: Long) {
        boardRepository.delete(id)
    }

    @Transactional
    fun modifyBoard(modifyBoard: ModifyBoard): Board {
        return boardRepository.update(modifyBoard)
    }

    @Transactional(readOnly = true)
    fun getBoards(): List<Board> {
        return boardRepository.findAll()
    }

}