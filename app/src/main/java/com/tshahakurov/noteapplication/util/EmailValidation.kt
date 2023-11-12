package com.tshahakurov.noteapplication.util

fun String.isEmailValid(): Boolean {
    return if (isNullOrBlank()) false
    else {
        val regexPattern = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z0-9.-]\$")
        regexPattern.matches(this)
    }
}
