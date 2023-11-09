package com.tshahakurov.noteapplication.view.fragment.note.info

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.databinding.FragmentNoteInformationBinding
import com.tshahakurov.noteapplication.model.ListItem

const val BUNDLE_KEY = "note"

class NoteInformationFragment : Fragment() {

    private var _binding: FragmentNoteInformationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteInformationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt(BUNDLE_KEY, 1)?.let { id ->
            viewModel.getNoteById(id)
        }

        viewModel.note.observe(viewLifecycleOwner) { note ->
            when (note) {
                is ListItem.BasicNote -> {
                    with(binding) {
                        titleTextView.text = note.title
                        bodyTextView.text = note.body
                        dateTextView.text = note.date
                    }
                }

                is ListItem.ImportantNote -> {
                    with(binding) {
                        priorityTextView.isVisible = true
                        warningImageView.isVisible = true
                        titleTextView.text = note.title
                        bodyTextView.text = note.body
                        dateTextView.text = note.date
                        priorityTextView.text = getPriority(note)
                    }
                }
            }
        }

        shareButtonListener()
    }

    private fun shareButtonListener() {
        val shareMessageIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, generateMessage(viewModel.note.value))
        }
        val intentChooser = Intent.createChooser(shareMessageIntent, "Share using ...")

        binding.shareButton.setOnClickListener {
            startActivity(intentChooser)
        }
    }

    private fun generateMessage(note: ListItem?): String {
        return note.toString()
    }

    private fun getPriority(item: ListItem.ImportantNote): String {
        return "${item.priority}/10"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}