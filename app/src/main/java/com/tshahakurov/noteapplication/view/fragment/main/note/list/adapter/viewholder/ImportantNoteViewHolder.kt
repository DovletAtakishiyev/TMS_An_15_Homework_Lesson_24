package com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.NoteItemImportantBinding
import com.tshahakurov.noteapplication.model.Note

class ImportantNoteViewHolder(private val binding: NoteItemImportantBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Note.ImportantNote,
        onClickListener: (Note) -> Unit,
        onLongClickListener: (Note, View) -> Unit,
        onBookmarkClicked: (Note, Boolean) -> Unit
    ) {

        with(binding) {
            cardTitle.text = item.title
            cardBody.text = item.body
            cardDate.text = item.date
            cardPriority.text = item.priority.toString()
            cardBookmark.isChecked = item.bookmark
            importantImageView.setImageResource(
                R.drawable.important_icon
            )

            root.setOnClickListener { onClickListener(item) }
            root.setOnLongClickListener {
                onLongClickListener(item, root)
                true
            }
            cardBookmark.setOnCheckedChangeListener { _, isChecked ->
                onBookmarkClicked(item, isChecked)
            }

            bindBackground()
        }
    }

    private fun bindBackground() {
        binding.layout.setBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                R.color.card_background_important
            )
        )
    }

    companion object {
        fun from(parent: ViewGroup): ImportantNoteViewHolder {
            return ImportantNoteViewHolder(
                NoteItemImportantBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}