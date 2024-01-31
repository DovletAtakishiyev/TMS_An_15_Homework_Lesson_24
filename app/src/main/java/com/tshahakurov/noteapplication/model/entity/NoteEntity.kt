package com.tshahakurov.noteapplication.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tshahakurov.noteapplication.util.Util

@Entity(Util.NOTE_TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Util.ID_COLUMN_NAME)
    val id: Int?,
    @ColumnInfo(name = Util.TITLE_COLUMN_NAME)
    val title: String,
    @ColumnInfo(name = Util.BODY_COLUMN_NAME)
    val body: String,
    @ColumnInfo(name = Util.DATE_COLUMN_NAME)
    val date: String,
    @ColumnInfo(name = Util.IS_IMPORTANT_COLUMN_NAME)
    val isImportant: Boolean,
    @ColumnInfo(name = Util.PRIORITY_COLUMN_NAME)
    val priority: Int?,
    @ColumnInfo(name = Util.BOOKMARK_COLUMN_NAME)
    val isBookmark: Boolean
)
