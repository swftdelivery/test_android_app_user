package com.gox.app.data.repositary.remote.model

data class VerifyOTPResponse(
    val error: List<Any> = listOf(),
    val message: String = "",
    val responseData: List<Any> = listOf(),
    val statusCode: String = "",
    val title: String = ""
)