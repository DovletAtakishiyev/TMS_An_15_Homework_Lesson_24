package com.tshahakurov.noteapplication.view.fragment.main.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.view.fragment.main.bookmark.NoteItem

@SuppressLint("MutableCollectionMutableState")
@Composable
fun SearchScreen() {
    var searchItem by remember { mutableStateOf("") }
    val viewModel: SearchViewModel = viewModel()
    val foundNotes by viewModel.noteList.observeAsState(emptyList())

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp)
        ) {

            TextField(
                value = searchItem,
                maxLines = 1,

                onValueChange = {
                    searchItem = it
                    viewModel.searchForNoteByTitle(it)
                    Log.wtf("suita", "onValueChanged")
                },
                label = { Text(text = "Search") },
                modifier = Modifier.fillMaxWidth(),
            )

            LazyColumn {
                items(foundNotes) { note ->
                    NoteItem(note = note)
                }
            }

        }

    }
}