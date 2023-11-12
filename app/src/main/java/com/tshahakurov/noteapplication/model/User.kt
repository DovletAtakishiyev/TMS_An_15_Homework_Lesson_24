package com.tshahakurov.noteapplication.model

data class User(
    val id: Int? = 0,
    val email: String,
    val firstName: String = "Anonymous",
    val lastName: String = "Anonymous"
)