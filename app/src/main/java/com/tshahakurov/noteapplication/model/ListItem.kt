package com.tshahakurov.noteapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed interface ListItem : Parcelable {

    @Parcelize
    data class BasicNote(
        val title: String,
        val body: String,
        val date: String
    ) : ListItem {
        override fun toString(): String {
            return """Basic Note :
                |Title : $title
                |Body  : $body
                |Date  : $date
                """.trimMargin()
        }
    }

    @Parcelize
    data class ImportantNote(
        val title: String,
        val body: String,
        val date: String,
        val priority: Int
    ) : ListItem {

        constructor(
            basicNote: BasicNote,
            priority: Int):this(
            basicNote.title,
            basicNote.body,
            basicNote.date,
            priority
        )

        override fun toString(): String {
            return """Important Note : 
                |Title    : $title
                |Body     : $body
                |Date     : $date
                |Priority : $priority
                """.trimMargin()
        }
    }
}
