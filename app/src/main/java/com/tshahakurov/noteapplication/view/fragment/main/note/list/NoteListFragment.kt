package com.tshahakurov.noteapplication.view.fragment.main.note.list

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentNoteListBinding
import com.tshahakurov.noteapplication.model.Note
import com.tshahakurov.noteapplication.util.replaceFragmentWithStack
import com.tshahakurov.noteapplication.view.fragment.main.note.add.AddNoteFragment
import com.tshahakurov.noteapplication.view.fragment.main.note.info.BUNDLE_KEY
import com.tshahakurov.noteapplication.view.fragment.main.note.info.NoteInformationFragment
import com.tshahakurov.noteapplication.view.fragment.main.note.list.adapter.CustomAdapter
import com.tshahakurov.noteapplication.view.fragment.main.dialog.DeleteDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.noteList.observe(viewLifecycleOwner) { list -> submitList(list) }
        viewModel.getNoteList()

        binding.floatingActionButton.setOnClickListener {
            parentFragmentManager.replaceFragmentWithStack(
                R.id.mainFragmentContainer,
                AddNoteFragment()
            )
        }
    }

    private fun submitList(list: List<Note>) {
        binding.recyclerView.run {
            if (adapter == null) {

                layoutManager = LinearLayoutManager(requireContext())
                adapter = CustomAdapter(

                    onClickListener = { note -> onItemClicked(note) },

                    onLongClickListener = { note, view -> onItemLongClicked(note, view) },

                    onBookmarkClickListener = { note, isChecked ->
                        onItemBookmarkClicked(
                            note,
                            isChecked
                        )
                    }
                )
            } else {
                (adapter as CustomAdapter).submitList(list)
            }
        }
    }

    private fun onItemClicked(note: Note) {

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainer, NoteInformationFragment().apply {
                arguments = bundleOf(BUNDLE_KEY to note.id)
            })
            .addToBackStack("note_info")
            .commit()
    }

    private fun onItemLongClicked(note: Note, view: View?) {

        val popupMenu = PopupMenu(context, view, Gravity.END)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit_mi -> {
                    Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.delete_mi -> {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                    DeleteDialog { viewModel.removeNote(note) }.show(
                        childFragmentManager,
                        "suita"
                    )
                    true
                }

                else ->
                    false
            }
        }
        popupMenu.setOnDismissListener {}
        popupMenu.show()
    }

    private fun onItemBookmarkClicked(note: Note, isChecked: Boolean) {
        viewModel.addBookmark(note, isChecked)
        Log.wtf("suita", "Click $isChecked - $note")
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