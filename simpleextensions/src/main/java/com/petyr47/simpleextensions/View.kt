package com.petyr47.simpleextensions

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

inline fun <T: View> T.hideIf(condition: (T) -> Boolean) {
    if(condition(this)) {
        visibility = View.INVISIBLE
    } else {
        visibility = View.VISIBLE
    }
}