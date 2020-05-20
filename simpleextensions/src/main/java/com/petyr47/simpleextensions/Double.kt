package com.petyr47.simpleextensions

import java.text.DecimalFormat

fun Double.removeScientificNotation() : String{
    val df = DecimalFormat("#")
    df.maximumFractionDigits = 2
    return df.format(this)
}