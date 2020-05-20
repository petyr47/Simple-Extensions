package com.petyr47.simpleextensions

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AlertDialog

fun Context.isOnline(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}


/*
* This function Create a logout confirmation dialog,
*
* param[logout] is the logout function to be executed if the positive button is
* clicked
*
*param[theme] is a style defined in res/value/styles.xml
* to determine the style of the dialog

* */
fun Context.makeLogoutDialog(logout: (() -> Unit), theme: Int? = null) {

    val builder = when (theme) {
        (null) -> AlertDialog.Builder(this)
        else -> AlertDialog.Builder(this, theme)
    }
    builder.setTitle("Are you sure you want to logout?")
    builder.setCancelable(true)
    builder.setMessage("Press OK to logout")

    builder.setNegativeButton(
        "Cancel"
    ) { dialog, _ -> dialog.dismiss() }

    builder.setPositiveButton("OK") { _, _ -> logout() }

    val dialog = builder.create()
    dialog.show()
}