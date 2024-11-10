package com.example.ktboard.storage.core.entity

import com.example.ktboard.domain.board.model.ModifyBoard
import jakarta.persistence.*

@Entity
@Table(name = "board")
class BoardEntity(

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "user_id")
    val userId: Long,
) : BaseEntity() {

    fun modify(modifyBoard: ModifyBoard) {
        this.title = modifyBoard.title
        this.content = modifyBoard.content
    }

}