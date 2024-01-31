package com.tshahakurov.noteapplication.model

sealed interface Note {
    val id: Int?
    var bookmark: Boolean

    fun provideTitle(): String
    fun provideBody(): String
    fun provideDate(): String

    data class BasicNote(
        override val id: Int?,
        val title: String,
        val body: String,
        val date: String,
        override var bookmark: Boolean
    ) : Note {
        override fun provideTitle(): String = title

        override fun provideBody(): String = body

        override fun provideDate(): String = date

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
        val priority: Int,
        override var bookmark: Boolean
    ) : Note {

        constructor(
            basicNote: BasicNote,
            priority: Int
        ) : this(
            basicNote.id,
            basicNote.title,
            basicNote.body,
            basicNote.date,
            priority,
            basicNote.bookmark
        )

        override fun provideTitle(): String = title

        override fun provideBody(): String = body

        override fun provideDate(): String = date

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
