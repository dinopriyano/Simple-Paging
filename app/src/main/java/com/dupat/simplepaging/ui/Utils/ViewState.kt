package com.dupat.simplepaging.ui.Utils

sealed class ViewState {
    data class isLoading(var state: Boolean = false) : ViewState()
    data class isError(var err: String? = null, var what: Int? = null) : ViewState()
    data class isSuccess(var what: Int? = null, var value: Any? = null) : ViewState()
    object Reset : ViewState()
}