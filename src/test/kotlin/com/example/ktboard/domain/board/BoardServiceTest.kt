package com.example.ktboard.domain.board

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class BoardServiceTest(
    @Autowired val boardService: BoardService,
) {
}