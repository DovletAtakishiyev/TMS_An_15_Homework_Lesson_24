package com.tshahakurov.noteapplication.util

import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.model.entity.ListItemEntity

fun ArrayList<ListItemEntity>.toNoteList(): ArrayList<ListItem> = this.map {
    it.toListItem()
} as ArrayList<ListItem>

fun ListItemEntity.toListItem(): ListItem {
    return when (this) {
        is ListItemEntity.BasicNote -> ListItem.BasicNote(
            id, title, body, date
        )

        is ListItemEntity.ImportantNote -> ListItem.ImportantNote(
            id, title, body, date, priority
        )
    }
}

fun ListItem.toListItemEntity(): ListItemEntity {
    return when (this) {
        is ListItem.BasicNote -> ListItemEntity.BasicNote(id, title, body, date)
        is ListItem.ImportantNote -> ListItemEntity.ImportantNote(id, title, body, date, priority)
    }
}