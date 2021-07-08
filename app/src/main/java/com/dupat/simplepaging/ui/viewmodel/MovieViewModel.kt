package com.dupat.simplepaging.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.dupat.simplepaging.ui.Utils.SingleLiveEvent
import com.dupat.simplepaging.ui.Utils.ViewState
import com.dupat.simplepaging.ui.model.MovieDetailModel
import com.dupat.simplepaging.ui.network.ApiInterface
import com.dupat.simplepaging.ui.network.RetrofitInstance
import com.dupat.simplepaging.ui.network.repositories.MovieRepository
import com.dupat.simplepaging.ui.paging.MoviePaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val apiInterface: ApiInterface, private val movieRepository: MovieRepository) : ViewModel() {

    private var state: SingleLiveEvent<ViewState> = SingleLiveEvent()
    private var movie = MutableLiveData<MovieDetailModel>()

    val movies = Pager(PagingConfig(pageSize = 20)){
        MoviePaging(apiInterface)
    }.liveData.cachedIn(viewModelScope)

    fun movieDetail(movieID: Int){
        state.value = ViewState.isLoading(true)
        viewModelScope.launch {
            try {
                val response = movieRepository.getMovieDetail(movieID)
                response.let {
                    movie.postValue(it)
                    state.value = ViewState.isLoading(false)
                    return@launch
                }
            }
            catch (e: Exception){
                state.value = ViewState.isLoading(false)
                state.value = ViewState.isError(e.message)
            }
        }
    }


    fun getState() = state
    fun getMovie() = movie

}