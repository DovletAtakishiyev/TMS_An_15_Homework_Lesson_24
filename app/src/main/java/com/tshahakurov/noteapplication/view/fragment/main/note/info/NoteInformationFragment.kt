package com.tshahakurov.noteapplication.view.fragment.main.note.info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.databinding.FragmentNoteInformationBinding
import com.tshahakurov.noteapplication.model.Note
import dagger.hilt.android.AndroidEntryPoint

const val BUNDLE_KEY = "note"

@AndroidEntryPoint
class NoteInformationFragment : Fragment() {

    private var _binding: FragmentNoteInformationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteInformationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher
            .addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    parentFragmentManager.popBackStack()
                }
            })
    }

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
                is Note.BasicNote -> {
                    with(binding) {
                        titleTextView.text = note.title
                        bodyTextView.text = note.body
                        dateTextView.text = note.date
                    }
                }

                is Note.ImportantNote -> {
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
        binding.shareButton.setOnClickListener {
            val shareMessageIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, viewModel.provideCurrentNote())
            Log.wtf("suita", "------------------- 1")
        }
            val intentChooser = Intent.createChooser(shareMessageIntent, "Share using ...")
            Log.wtf("suita", "------------------- 2")
            Log.wtf("suita", viewModel.provideCurrentNote())
            startActivity(intentChooser)
        }
    }

    private fun getPriority(item: Note.ImportantNote): String {
        return "${item.priority}/10"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}