package com.tshahakurov.noteapplication.view.fragment.note.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.repository.NoteRepository

class NoteInformationViewModel : ViewModel() {

    val note = MutableLiveData<ListItem>()

    private val repository = NoteRepository()
    fun getNoteById(id: Int) {
        note.value = repository.getNoteById(id)
    }
}