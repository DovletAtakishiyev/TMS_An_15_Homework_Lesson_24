package com.tshahakurov.noteapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tshahakurov.noteapplication.model.entity.NoteEntity
import com.tshahakurov.noteapplication.util.Util.NOTE_TABLE_NAME

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Insert
    suspend fun addNoteList(noteList: ArrayList<NoteEntity>)

    @Delete
    suspend fun removeNote(note: NoteEntity)

    @Delete
    suspend fun removeNoteList(noteList: ArrayList<NoteEntity>)

    @Update
    suspend fun editNote(note: NoteEntity)

    @Query("SELECT * FROM $NOTE_TABLE_NAME")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM $NOTE_TABLE_NAME WHERE id = :id LIMIT 1")
    suspend fun getNoteById(id: Int): NoteEntity
}