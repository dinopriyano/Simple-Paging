package com.dupat.simplepaging.ui.model

data class ErrorModel(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)