package com.tshahakurov.noteapplication.util

import android.icu.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {
//    var isLogin = false

    const val REGISTRATION_ERROR_MESSAGE = "Something went wrong"

    fun getCurrentDate(): String =
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

}