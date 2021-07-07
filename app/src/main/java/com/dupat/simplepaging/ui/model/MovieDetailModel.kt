package com.dupat.simplepaging.ui.model

data class MovieDetailModel(
    val backdrop_path: String,
    val genres: List<GenreModel>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompanyModel>,
    val production_countries: List<ProductionCountryModel>,
    val release_date: String,
    val spoken_languages: List<SpokenLanguageModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)