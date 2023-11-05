package com.tshahakurov.noteapplication.view.fragment.book.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentNoteListBinding
import com.tshahakurov.noteapplication.util.replaceFragmentWithStack
import com.tshahakurov.noteapplication.view.fragment.book.add.AddNoteFragment

class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            floatingActionButton.setOnClickListener {
                parentFragmentManager.replaceFragmentWithStack(
                    R.id.fragmentContainer, AddNoteFragment()
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}