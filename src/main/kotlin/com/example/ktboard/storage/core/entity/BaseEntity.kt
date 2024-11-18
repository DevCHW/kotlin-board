package com.example.ktboard.storage.core.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @CreationTimestamp
    @Column(name = "timestamp_created_at")
    val createdAt: LocalDateTime = LocalDateTime.MIN

    @UpdateTimestamp
    @Column(name = "timestamp_updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.MIN
}