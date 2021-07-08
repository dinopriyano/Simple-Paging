package com.dupat.simplepaging.ui.Utils

import android.app.Activity
import android.view.View
import com.dupat.simplepaging.R
import com.google.android.material.snackbar.Snackbar


fun View.snackbar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setActionTextColor(resources.getColor(R.color.black))
        snackbar.setBackgroundTint(resources.getColor(R.color.white))
        snackbar.setAction("OK") {
            snackbar.dismiss()
        }
    }.show()
}

fun Activity.statusBarHeight(): Int{
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun Int.getBackground(): Int{
    return when((this+1) % 6){
        1 -> R.drawable.gradient_blue
        2 -> R.drawable.gradient_pink
        3 -> R.drawable.gradient_orange
        4 -> R.drawable.gradient_purple
        5 -> R.drawable.gradient_blue_sea
        else -> R.drawable.gradient_red_heart
    }
}
