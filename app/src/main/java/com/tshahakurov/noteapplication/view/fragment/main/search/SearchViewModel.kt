package com.tshahakurov.noteapplication.view.fragment.main.search

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
class SearchViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val noteList = MutableLiveData<ArrayList<Note>>()

    fun searchForNoteByTitle(title: String){
        viewModelScope.launch(Dispatchers.IO) {
            if (title.isNotBlank())
                noteList.postValue(repository.findNoteByTitle(title))
            else
                noteList.postValue(arrayListOf())
        }
    }

}