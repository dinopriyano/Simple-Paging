package com.dupat.simplepaging.ui.model

data class ResultModel(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)