package com.tshahakurov.noteapplication.view.fragment.main.note.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.repository.NoteRepository
import com.tshahakurov.noteapplication.util.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val title = MutableLiveData<String>()
    val body = MutableLiveData<String>()
    val isImportant = MutableLiveData<Boolean>()
    val priority = MutableLiveData<Int>()

    val isAdding = MutableLiveData(false)


    private lateinit var note: Note

    fun addNote() {
        viewModelScope.launch(Dispatchers.IO) {
            isAdding.postValue(true)
            createNote()
            delay(500)
            noteRepository.addNoteToDataBase(note)
            isAdding.postValue(false)
        }
    }

    private fun createNote() {
        val titleValue = title.value ?: ""
        val bodyValue = body.value ?: ""
        val currentDate = Util.getCurrentDate()

        if (titleValue.isNotBlank() && bodyValue.isNotBlank()) {
            val basicNote = Note.BasicNote(null, titleValue, bodyValue, currentDate, false)
            note = if (isImportant.value == true) {
                val priorityValue = priority.value ?: 5
                val importantNote = Note.ImportantNote(basicNote, priorityValue)
                importantNote
            } else {
                basicNote
            }
        }
    }
}