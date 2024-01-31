package com.tshahakurov.noteapplication.view.fragment.main.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tshahakurov.noteapplication.model.Note

@Composable
fun BookmarkScreen(
    list: List<Note>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Bookmark Notes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            if (list.isNotEmpty())
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    for (note in list) {
                        NoteItem(note = note)
                    }
                }
            else
                Text(text = "Here will be your Bookmarks")
        }
    }
}


@Composable
fun NoteItem(
    note: Note
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp))
            .background(
                if (note is Note.ImportantNote) Color.Red
                else Color.Cyan
            )
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = note.provideTitle(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = note.provideBody(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.End
            ) {
                Text(text = note.provideDate(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                if (note is Note.ImportantNote) {
                    Text(
                        text = "${note.priority}/10",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Check() {
//    BookmarkScreen()
}