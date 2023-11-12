package com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.NoteItemBasicBinding
import com.tshahakurov.noteapplication.model.Note

class BasicNoteViewHolder(private val binding: NoteItemBasicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Note.BasicNote, onClickListener: (Note) -> Unit) {
        with(binding) {
            cardTitle.text = item.title
            cardBody.text = item.body
            cardDate.text = item.date

            root.setOnClickListener { onClickListener(item) }

            bindBackground()
        }
    }

    private fun bindBackground() {
        binding.layout.setBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                when {
                    layoutPosition % 3 == 0 -> R.color.card_background_3
                    layoutPosition % 3 == 1 -> R.color.card_background_2
                    else -> R.color.card_background_1
                }
            )
        )
    }

    companion object {
        fun from(parent: ViewGroup): BasicNoteViewHolder {
            return BasicNoteViewHolder(
                NoteItemBasicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}