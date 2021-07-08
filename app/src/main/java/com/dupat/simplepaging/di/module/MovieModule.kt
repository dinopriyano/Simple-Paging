package com.dupat.simplepaging.di.module

import com.dupat.simplepaging.ui.network.ApiInterface
import com.dupat.simplepaging.ui.network.RetrofitInstance
import com.dupat.simplepaging.ui.network.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): ApiInterface{
        return RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    }

    @Provides
    fun getMovieRepository(apiInterface: ApiInterface) : MovieRepository{
        return MovieRepository(apiInterface)
    }

}