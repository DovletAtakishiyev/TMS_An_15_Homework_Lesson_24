package com.tshahakurov.noteapplication.view.fragment.note.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            importantCheckbox.setOnCheckedChangeListener { _, isChecked ->
                priorityTextView.isVisible = isChecked
                priorityInput.isVisible = isChecked
                viewModel.isImportant.value = isChecked
            }

            titleInputMain.addTextChangedListener { viewModel.title.value = it.toString() }
            bodyInputMain.addTextChangedListener { viewModel.body.value = it.toString() }
            priorityInput.addTextChangedListener {
                viewModel.priority.value = it.toString().toIntOrNull() ?: 5
            }

            clearButton.setOnClickListener {
                titleInputMain.setText("")
                bodyInputMain.setText("")
                importantCheckbox.isChecked = false
            }

            addNoteButton.setOnClickListener {
                viewModel.addNote()
                Toast.makeText(requireContext(), "Note was added", Toast.LENGTH_SHORT).show()
                parentFragmentManager.popBackStack()
            }
        }

        viewModel.title.observe(viewLifecycleOwner) {
            validate()
        }

        viewModel.body.observe(viewLifecycleOwner) {
            validate()
        }
    }

    private fun validate() {
        val titleNotBlank = viewModel.title.value?.isNotBlank() == true
        val bodyNotBlank = viewModel.body.value?.isNotBlank() == true
        binding.addNoteButton.isEnabled = titleNotBlank && bodyNotBlank
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}