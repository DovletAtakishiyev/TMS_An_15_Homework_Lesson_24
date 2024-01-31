package com.tshahakurov.noteapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tshahakurov.noteapplication.model.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}