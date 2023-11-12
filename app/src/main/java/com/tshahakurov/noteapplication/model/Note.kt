package com.tshahakurov.noteapplication.model

sealed interface Note {
    val id: Int?

    data class BasicNote(
        override val id: Int?,
        val title: String,
        val body: String,
        val date: String
    ) : Note {

        override fun toString(): String {
            return """Basic Note :
                |Title : $title
                |Body  : $body
                |Date  : $date
                """.trimMargin()
        }
    }

    data class ImportantNote(
        override val id: Int?,
        val title: String,
        val body: String,
        val date: String,
        val priority: Int
    ) : Note {

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
