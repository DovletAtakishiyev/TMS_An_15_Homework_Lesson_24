package com.tshahakurov.noteapplication.util

import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.model.entity.NoteEntity

fun ArrayList<NoteEntity>.toNoteList(): ArrayList<Note> = this.map {
    it.toNote()
} as ArrayList<Note>

fun NoteEntity.toNote(): Note {
    return if (isImportant) {
        Note.ImportantNote(id!!, title, body, date, priority!!, isBookmark)
    } else {
        Note.BasicNote(id!!, title, body, date, isBookmark)
    }
}

fun Note.toNoteEntity(): NoteEntity {
    return when (this) {
        is Note.BasicNote -> NoteEntity(id, title, body, date, false, null, bookmark)
        is Note.ImportantNote -> NoteEntity(id, title, body, date, true, priority, bookmark)
    }
}