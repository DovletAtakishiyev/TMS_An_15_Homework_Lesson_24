package com.tshahakurov.noteapplication.repository

import com.tshahakurov.noteapplication.db.NoteDao
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.model.entity.NoteEntity
import com.tshahakurov.noteapplication.util.toNote
import com.tshahakurov.noteapplication.util.toNoteEntity
import com.tshahakurov.noteapplication.util.toNoteList
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
){

    suspend fun getNoteList(): ArrayList<Note> =
        (noteDao.getAllNotes() as? ArrayList<NoteEntity>)?.toNoteList() ?: arrayListOf()

    suspend fun getNoteById(id: Int) = noteDao.getNoteById(id).toNote()

    suspend fun addNoteToDataBase(note: Note) {
        noteDao.addNote(note.toNoteEntity())
    }
}