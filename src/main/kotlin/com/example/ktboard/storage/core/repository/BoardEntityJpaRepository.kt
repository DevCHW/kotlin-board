package com.example.ktboard.storage.core.repository

import com.example.ktboard.storage.core.entity.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardEntityJpaRepository : JpaRepository<BoardEntity, Long> {
}