package com.tshahakurov.noteapplication.view.fragment.main.note.list

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
class NoteListViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val noteList = MutableLiveData<List<Note>>()

    fun getNoteList() {
        viewModelScope.launch(Dispatchers.IO) {
            noteList.postValue(repository.getNoteList().asReversed())
        }
    }

    fun removeNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
            getNoteList()
        }
    }

    fun addBookmark(note: Note, isChecked: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            note.bookmark = isChecked
            repository.editNote(note)
        }
    }
}