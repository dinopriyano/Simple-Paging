package com.dupat.simplepaging.ui.network

import com.dupat.simplepaging.ui.Utils.Constant
import com.dupat.simplepaging.ui.model.MovieDetailModel
import com.dupat.simplepaging.ui.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("top_rated")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("page") page: Int
    ) : Response<MovieModel>

    @GET("{movieID}")
    suspend fun getMovieDetail(
        @Path("movieID") movieID: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ) : Response<MovieDetailModel>

}