package com.tshahakurov.noteapplication.model

import android.support.v4.os.IResultReceiver2.Default

data class User(
    val id: Int? = 0,
    val email: String,
    val firstName: String = "Anonymous",
    val lastName: String = "Anonymous"
)