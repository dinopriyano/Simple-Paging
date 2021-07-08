package com.dupat.simplepaging.ui.network.repositories

import com.dupat.simplepaging.ui.model.MovieDetailModel
import com.dupat.simplepaging.ui.network.ApiInterface
import com.dupat.simplepaging.ui.network.SafeAPIRequest
import retrofit2.Response

class MovieRepository(private val apiInterface: ApiInterface): SafeAPIRequest() {

    suspend fun getMovieDetail(movieID: Int) = apiRequest { apiInterface.getMovieDetail(movieID) }

}