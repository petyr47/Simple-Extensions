package com.petyr47.simpleextensions

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import java.text.NumberFormat
import java.util.*


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




/*
* This function extends the capabilities of Int object,
* allowing it to create a Correctly formatted string that has the naira symbol
* */
fun Int.makeMoney(): String {
    return "₦ ${NumberFormat.getNumberInstance(Locale.getDefault()).format(this)}"
}



/*
* function to protect an observer when livedata returns null
*
* param[observer] will only run when the value being observed has changed and is not null
*
*
* */

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, androidx.lifecycle.Observer {
        it?.let(observer)
    })
}