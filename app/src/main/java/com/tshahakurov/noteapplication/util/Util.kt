package com.tshahakurov.noteapplication.util

import android.icu.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {

    // DB constants ->
    const val DATA_BASE_NAME = "note_db"
    const val NOTE_TABLE_NAME = "notes"
    const val ID_COLUMN_NAME = "id"
    const val TITLE_COLUMN_NAME = "title"
    const val BODY_COLUMN_NAME = "body"
    const val DATE_COLUMN_NAME = "date"
    const val IS_IMPORTANT_COLUMN_NAME = "is_important"
    const val PRIORITY_COLUMN_NAME = "priority"
    const val BOOKMARK_COLUMN_NAME = "bookmark"

    fun getCurrentDate(): String =
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

}