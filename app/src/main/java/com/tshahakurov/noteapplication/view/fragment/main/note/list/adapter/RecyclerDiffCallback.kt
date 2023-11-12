package com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tshahakurov.noteapplication.model.Note

object RecyclerDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}