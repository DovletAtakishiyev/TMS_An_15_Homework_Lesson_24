package com.tshahakurov.noteapplication.view.fragment.note.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.view.fragment.note.list.adapter.viewholder.BasicNoteViewHolder
import com.tshahakurov.noteapplication.view.fragment.note.list.adapter.viewholder.ImportantNoteViewHolder

class CustomAdapter(
    private val onClickListener: (position: ListItem) -> Unit
) : ListAdapter<ListItem, RecyclerView.ViewHolder>(RecyclerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BASIC_NOTE -> BasicNoteViewHolder.from(parent)
            IMPORTANT_NOTE -> ImportantNoteViewHolder.from(parent)
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is BasicNoteViewHolder && item is ListItem.BasicNote) {
            holder.bind(item, onClickListener)
        } else if (holder is ImportantNoteViewHolder && item is ListItem.ImportantNote) {
            holder.bind(item, onClickListener)
        } else {
            throw java.lang.IllegalStateException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListItem.BasicNote -> BASIC_NOTE
            is ListItem.ImportantNote -> IMPORTANT_NOTE
        }
    }

    companion object {
        private const val BASIC_NOTE = 1
        private const val IMPORTANT_NOTE = 2
    }
}