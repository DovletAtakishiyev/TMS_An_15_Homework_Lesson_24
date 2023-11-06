package com.tshahakurov.noteapplication.model.entity

import android.os.Parcelable
import com.tshahakurov.noteapplication.model.ListItem
import kotlinx.parcelize.Parcelize

@Parcelize
sealed interface ListItemEntity : Parcelable {

    val id: Int

    @Parcelize
    data class BasicNote(
        override val id: Int,
        val title: String,
        val body: String,
        val date: String
    ) : ListItemEntity {

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
        override val id: Int,
        val title: String,
        val body: String,
        val date: String,
        val priority: Int
    ) : ListItemEntity {

        constructor(
            basicNote: BasicNote,
            priority: Int
        ) : this(
            basicNote.id,
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
