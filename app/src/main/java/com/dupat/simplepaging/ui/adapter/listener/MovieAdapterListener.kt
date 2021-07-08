package com.dupat.simplepaging.ui.adapter.listener

import com.dupat.simplepaging.ui.model.ResultModel

interface MovieAdapterListener {
    fun OnMovieClick(model: ResultModel, position: Int)
}