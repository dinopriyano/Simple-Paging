package com.dupat.simplepaging.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.dupat.simplepaging.ui.network.ApiInterface
import com.dupat.simplepaging.ui.network.RetrofitInstance
import com.dupat.simplepaging.ui.paging.MoviePaging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val apiInterface: ApiInterface) : ViewModel() {

    val movies = Pager(PagingConfig(pageSize = 20)){
        MoviePaging(apiInterface)
    }.liveData.cachedIn(viewModelScope)

}