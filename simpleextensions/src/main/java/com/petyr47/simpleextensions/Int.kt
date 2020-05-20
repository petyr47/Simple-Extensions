package com.petyr47.simpleextensions

import java.text.NumberFormat
import java.util.*

/*
* This function extends the capabilities of Int object,
* allowing it to create a Correctly formatted string that has the naira symbol
* */
fun Int.makeMoney(): String {
    return "₦ ${NumberFormat.getNumberInstance(Locale.getDefault()).format(this)}"
}