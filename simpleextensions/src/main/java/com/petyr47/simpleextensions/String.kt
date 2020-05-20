package com.petyr47.simpleextensions

import android.util.Patterns
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH)
    val targetFormat = SimpleDateFormat("EEEE, dd-MM-yyyy 'at' hh:mm a", Locale.ENGLISH)
    var date: Date? = null
    try {
        date = originalFormat.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return targetFormat.format(date)
}

fun String.getDates(): String {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH)
    val targetFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    var date: Date? = null
    try {
        date = originalFormat.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return targetFormat.format(date)
}

fun String?.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidUrl() : Boolean = this.isNotEmpty() &&
        Patterns.WEB_URL.matcher(this).matches()

fun String.pluralize(value : Int): String =
    when(value > 1){
        true -> "$value ${this}s"
        false -> "$value $this"
    }
