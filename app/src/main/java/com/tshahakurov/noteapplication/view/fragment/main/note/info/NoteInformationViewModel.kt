package com.tshahakurov.noteapplication.view.fragment.main.note.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteInformationViewModel : ViewModel() {

    val note = MutableLiveData<Note>()

    private val repository = NoteRepository()
    fun getNoteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            note.postValue(repository.getNoteById(id))
        }

    }
}