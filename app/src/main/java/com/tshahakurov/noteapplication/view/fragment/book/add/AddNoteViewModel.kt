package com.tshahakurov.noteapplication.view.fragment.book.add

import android.icu.text.SimpleDateFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.repository.NoteRepository
import java.util.Date
import java.util.Locale

class AddNoteViewModel : ViewModel() {
    val title = MutableLiveData<String>()
    val body = MutableLiveData<String>()
    val isImportant = MutableLiveData<Boolean>()
    val priority = MutableLiveData<Int>()

    private val noteRepository = NoteRepository()
    private lateinit var note: ListItem

    fun addNote() {
        createNote()
        noteRepository.addNoteToDataBase(note)
    }

    private fun createNote() {
        val titleValue = title.value ?: ""
        val bodyValue = body.value ?: ""
        val currentDate = getCurrentDate()

        if (titleValue.isNotBlank() && bodyValue.isNotBlank()) {
            val basicNote = ListItem.BasicNote(ListItem.getId(), titleValue, bodyValue, currentDate)
            if (isImportant.value == true) {
                val priorityValue = priority.value ?: 5
                val importantNote = ListItem.ImportantNote(basicNote, priorityValue)
                note = importantNote
            } else {
                note = basicNote
            }
        }
    }

    private fun getCurrentDate(): String =
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
}