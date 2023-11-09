package com.tshahakurov.noteapplication.view.fragment.note.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.repository.NoteRepository

class NoteListViewModel : ViewModel() {
    val noteList = MutableLiveData<ArrayList<ListItem>>()

    private val repository = NoteRepository()

    fun getNoteList() {
        noteList.value = repository.getNoteList()
    }
}