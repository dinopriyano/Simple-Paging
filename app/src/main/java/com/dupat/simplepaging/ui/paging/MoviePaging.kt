package com.dupat.simplepaging.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dupat.simplepaging.ui.model.ResultModel
import com.dupat.simplepaging.ui.network.ApiInterface

class MoviePaging(val apiInterface: ApiInterface) : PagingSource<Int, ResultModel>() {

    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
        val page = params.key?:1

        return try {
            val data = apiInterface.getPopularMovies(page = page)

            LoadResult.Page(
                data = data.body()?.results!!,
                prevKey = if(page == 1) null else page-1,
                nextKey = if(page >= data.body()?.total_pages!!) null else page+1
            )

        }
        catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}