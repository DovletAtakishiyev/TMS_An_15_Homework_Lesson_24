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

    suspend fun deleteNote(note: Note){
        noteDao.removeNote(note = note.toNoteEntity())
    }

    suspend fun editNote(note: Note){
        noteDao.editNote(note = note.toNoteEntity())
    }

    suspend fun getBookmarkNoteList(): ArrayList<Note> =
        (noteDao.getBookmarkNotes() as? ArrayList<NoteEntity>)?.toNoteList() ?: arrayListOf()

    suspend fun findNoteByTitle(title: String): ArrayList<Note> =
        (noteDao.findNoteByTitle(title) as? ArrayList<NoteEntity>)?.toNoteList() ?: arrayListOf()
}