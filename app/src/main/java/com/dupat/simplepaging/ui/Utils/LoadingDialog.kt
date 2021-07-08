package com.dupat.simplepaging.ui.Utils

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import com.dupat.simplepaging.R
import javax.inject.Inject

class LoadingDialog @Inject constructor(var activity: Activity) {

    lateinit var alertDialog: AlertDialog

    init {
        val builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.layout_loading_dialog, null))
        builder.setCancelable(false)

        alertDialog = builder.create()
    }

    fun startLoadingDialog() = alertDialog.show()

    fun dismisDialog() = alertDialog.dismiss()

    fun isDialogShowing() = alertDialog.isShowing
}