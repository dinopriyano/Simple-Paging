package com.dupat.simplepaging.ui.network

import com.dupat.simplepaging.ui.Utils.Constant
import com.dupat.simplepaging.ui.model.MovieModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("page") page: Int
    ) : MovieModel

}