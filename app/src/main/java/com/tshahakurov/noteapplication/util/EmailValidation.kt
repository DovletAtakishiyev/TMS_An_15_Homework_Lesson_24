package com.tshahakurov.noteapplication.util

fun String.isEmailValid(): Boolean {
    if (isNullOrBlank())
        return false
    else {
        val regexPattern = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z0-9.-]\$")
        return regexPattern.matches(this)
    }
}
