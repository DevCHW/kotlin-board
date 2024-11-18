package com.example.ktboard.storage

import com.example.ktboard.domain.board.BoardRepository
import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.domain.board.model.CreateBoard
import com.example.ktboard.domain.board.model.ModifyBoard
import com.example.ktboard.domain.error.CoreException
import com.example.ktboard.domain.error.ErrorType
import com.example.ktboard.storage.core.entity.BoardEntity
import com.example.ktboard.storage.core.repository.BoardEntityJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BoardCoreRepository(
    val boardEntityJpaRepository: BoardEntityJpaRepository,
) : BoardRepository {

    override fun findById(boardId: Long): Board {
        val boardEntity = boardEntityJpaRepository.findById(boardId)
            .orElseThrow{IllegalArgumentException("잘못된 ID 입니다.")}
        return Board(
            id = boardEntity.id,
            title = boardEntity.title,
            content = boardEntity.content,
            createdAt = boardEntity.createdAt,
            updatedAt = boardEntity.updatedAt,
        )
    }

    override fun save(createBoard: CreateBoard): Board {
        val savedUserEntity = boardEntityJpaRepository.save(
            BoardEntity(
                title = createBoard.title,
                content = createBoard.content,
                userId = createBoard.userId,
            )
        )

        return Board.of(savedUserEntity)
    }

    override fun update(modifyBoard: ModifyBoard): Board {
        val boardEntity = boardEntityJpaRepository.findByIdOrNull(modifyBoard.id)?: throw CoreException(ErrorType.BAD_REQUEST)
        boardEntity.modify(modifyBoard)
        return Board.of(boardEntity)
    }

    override fun findByIdOrNull(id: Long): Board? {
        val boardEntity = boardEntityJpaRepository.findByIdOrNull(id)
        return boardEntity?.let { Board.of(it) }
    }

    override fun delete(id: Long) {
        boardEntityJpaRepository.deleteById(id)
    }

    override fun findAll(): List<Board> {
        val boardEntities = boardEntityJpaRepository.findAll()
        return boardEntities.map { Board.of(it) }
    }
}