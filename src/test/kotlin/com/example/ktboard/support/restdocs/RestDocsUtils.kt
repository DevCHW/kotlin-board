package com.example.ktboard.support.restdocs

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor
import org.springframework.restdocs.operation.preprocess.Preprocessors

object RestDocsUtils {
    fun requestPreprocessor(): OperationRequestPreprocessor {
        return Preprocessors.preprocessRequest(
            Preprocessors.modifyUris().scheme("http").host("localhost:8080").removePort(),
            Preprocessors.prettyPrint(),
        )
    }

    fun responsePreprocessor(): OperationResponsePreprocessor {
        return Preprocessors.preprocessResponse(Preprocessors.prettyPrint())
    }
}