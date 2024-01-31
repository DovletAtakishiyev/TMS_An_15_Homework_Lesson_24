package com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter

import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter.viewholder.BasicNoteViewHolder
import com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter.viewholder.ImportantNoteViewHolder

class CustomAdapter(
    private val onClickListener: (position: Note) -> Unit,
    private val onLongClickListener: (position: Note, view: View) -> Unit,
    private val onBookmarkClickListener: (position: Note, isChecked: Boolean) -> Unit,
    ) : ListAdapter<Note, RecyclerView.ViewHolder>(RecyclerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BASIC_NOTE -> BasicNoteViewHolder.from(parent)
            IMPORTANT_NOTE -> ImportantNoteViewHolder.from(parent)
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (holder is BasicNoteViewHolder && item is Note.BasicNote) {
            holder.bind(item, onClickListener, onLongClickListener, onBookmarkClickListener)
        } else if (holder is ImportantNoteViewHolder && item is Note.ImportantNote) {
            holder.bind(item, onClickListener, onLongClickListener, onBookmarkClickListener)
        } else {
            throw java.lang.IllegalStateException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Note.BasicNote -> BASIC_NOTE
            is Note.ImportantNote -> IMPORTANT_NOTE
        }
    }

    companion object {
        private const val BASIC_NOTE = 1
        private const val IMPORTANT_NOTE = 2
    }
}