package com.tshahakurov.noteapplication.view.fragment.note.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentNoteListBinding
import com.tshahakurov.noteapplication.model.ListItem
import com.tshahakurov.noteapplication.util.replaceFragmentWithStack
import com.tshahakurov.noteapplication.view.fragment.note.add.AddNoteFragment
import com.tshahakurov.noteapplication.view.fragment.note.info.BUNDLE_KEY
import com.tshahakurov.noteapplication.view.fragment.note.info.NoteInformationFragment
import com.tshahakurov.noteapplication.view.fragment.note.list.adapter.CustomAdapter

class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            parentFragmentManager.replaceFragmentWithStack(
                R.id.fragmentContainer,
                AddNoteFragment()
            )
        }

        viewModel.noteList.observe(viewLifecycleOwner) { list ->
            submitList(list)
        }
        viewModel.getNoteList()
    }

    private fun submitList(list: ArrayList<ListItem>) {
        binding.recyclerView.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = CustomAdapter { note ->
                    parentFragmentManager.replaceFragmentWithStack(
                        R.id.fragmentContainer, NoteInformationFragment().apply {
                            arguments = bundleOf(BUNDLE_KEY to note.id)
                        }
                    )
                }
            } else {
                (adapter as CustomAdapter).submitList(list)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.noteList.observe(viewLifecycleOwner) { submitList(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}