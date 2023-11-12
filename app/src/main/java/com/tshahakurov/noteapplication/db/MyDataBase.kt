package com.tshahakurov.noteapplication.db

import android.content.Context
import androidx.room.Room
import com.tshahakurov.noteapplication.util.Util

object MyDataBase {

    var noteDao: NoteDao? = null

    fun createDataBase(context: Context) {
        val db: AppDataBase = Room.databaseBuilder(
            context, AppDataBase::class.java, Util.DATA_BASE_NAME
        ).build()
        noteDao = db.getNoteDao()
    }
}