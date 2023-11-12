package com.tshahakurov.noteapplication.repository

import com.tshahakurov.noteapplication.db.MyDataBase
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.model.entity.NoteEntity
import com.tshahakurov.noteapplication.util.toNote
import com.tshahakurov.noteapplication.util.toNoteEntity
import com.tshahakurov.noteapplication.util.toNoteList

class NoteRepository {

    suspend fun getNoteList(): ArrayList<Note> =
        (MyDataBase.noteDao?.getAllNotes() as? ArrayList<NoteEntity>)?.toNoteList() ?: arrayListOf()

    suspend fun getNoteById(id: Int) = MyDataBase.noteDao?.getNoteById(id)?.toNote()

    suspend fun addNoteToDataBase(note: Note) {
        MyDataBase.noteDao?.addNote(note.toNoteEntity())
    }
}