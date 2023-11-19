package com.tshahakurov.noteapplication.view.fragment.main.note.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteInformationViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val note = MutableLiveData<Note>()

    fun getNoteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            note.postValue(repository.getNoteById(id))
        }
    }
}