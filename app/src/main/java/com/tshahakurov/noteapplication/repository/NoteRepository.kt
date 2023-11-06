package com.tshahakurov.noteapplication.repository

import com.tshahakurov.noteapplication.db.NoteDataBase
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.util.toListItem
import com.tshahakurov.noteapplication.util.toListItemEntity
import com.tshahakurov.noteapplication.util.toNoteList

class NoteRepository {

    fun getNoteList(): ArrayList<ListItem> = NoteDataBase.list.toNoteList()

    fun addNoteToDataBase(note: ListItem) {
        NoteDataBase.list.add(note.toListItemEntity())
    }

    fun getNoteById(id: Int) =
        NoteDataBase.list.find {
            it.id == id
        }?.toListItem()
}