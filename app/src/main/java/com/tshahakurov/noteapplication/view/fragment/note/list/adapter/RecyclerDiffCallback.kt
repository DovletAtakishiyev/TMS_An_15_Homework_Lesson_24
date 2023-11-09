package com.tshahakurov.noteapplication.view.fragment.note.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tshahakurov.noteapplication.model.ListItem

object RecyclerDiffCallback : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}