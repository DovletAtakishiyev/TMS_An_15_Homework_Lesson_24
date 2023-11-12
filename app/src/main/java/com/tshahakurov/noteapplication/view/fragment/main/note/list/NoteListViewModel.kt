package com.tshahakurov.noteapplication.view.fragment.main.note.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel : ViewModel() {
    val noteList = MutableLiveData<ArrayList<Note>>()

    private val repository = NoteRepository()

    fun getNoteList() {
        viewModelScope.launch(Dispatchers.IO) {
            noteList.postValue(repository.getNoteList())
        }
    }
}