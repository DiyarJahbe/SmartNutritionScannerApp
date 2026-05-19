package com.example.smartnutritionscannerapp.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Extension functions for the application.
 */

fun Long.toDateString(): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
    return sdf.format(Date(this))
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)
