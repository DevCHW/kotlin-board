package com.example.ktboard.api.v1.board.controller

import com.example.ktboard.api.v1.board.application.BoardFacade
import com.example.ktboard.api.v1.board.application.dto.response.BoardResponse
import com.example.ktboard.domain.board.BoardService
import com.example.ktboard.domain.board.model.Board
import com.example.ktboard.support.restdocs.RestDocsTestSupport
import com.example.ktboard.support.restdocs.RestDocsUtils.requestPreprocessor
import com.example.ktboard.support.restdocs.RestDocsUtils.responsePreprocessor
import io.mockk.every
import io.mockk.mockk
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType.*
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.*

class BoardControllerTest : RestDocsTestSupport() {
    private lateinit var boardFacade: BoardFacade
    private lateinit var boardController: BoardController

    @BeforeEach
    fun setUp() {
        boardFacade = mockk()
        boardController = BoardController(boardFacade)
        mockMvc = mockController(boardController)
    }

    @DisplayName("게시글 단건 조회 API 문서 테스트")
    @Test
    fun getBoard() {
        val boardId = 1L;
        every { boardFacade.getBoard(any()) } returns BoardResponse.fixture();

        given()
            .contentType(ContentType.JSON)
            .get("/api/v1/boards/{boardId}", boardId)
            .then()
            .status(HttpStatus.OK)
            .apply(
                document(
                    "get-board",
                    requestPreprocessor(),
                    responsePreprocessor(),
                    pathParameters(
                        parameterWithName("boardId").description("게시글 ID"),
                    ),
                    responseFields(
                        fieldWithPath("result").type(STRING).description("ResultType (SUCCESS / ERROR"),
                        fieldWithPath("data.result").type(STRING).description("Result Date"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                        fieldWithPath("data.id").type(NUMBER).description("게시글 ID"),
                    ),
                ),
            )
    }


}