package com.tshahakurov.noteapplication.view.fragment.main.bookmark

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
class BookmarkViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val noteList = MutableLiveData<ArrayList<Note>>()

    fun getBookmarkNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            noteList.postValue(
                repository.getBookmarkNoteList().apply {
                    if (isNotEmpty())
                        reverse()
                }
            )
        }
    }
}