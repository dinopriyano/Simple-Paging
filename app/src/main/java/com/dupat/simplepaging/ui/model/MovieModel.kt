package com.dupat.simplepaging.ui.model

data class MovieModel(
    val page: Int,
    val results: List<ResultModel>,
    val total_pages: Int,
    val total_results: Int
)