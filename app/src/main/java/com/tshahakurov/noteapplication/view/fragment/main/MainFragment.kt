package com.tshahakurov.noteapplication.view.fragment.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentMainBinding
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.main.bookmark.BookmarkFragment
import com.tshahakurov.noteapplication.view.fragment.main.note.list.NoteListFragment
import com.tshahakurov.noteapplication.view.fragment.main.search.SearchNoteFragment
import com.tshahakurov.noteapplication.view.fragment.main.profile.UserProfileFragment
import dagger.hilt.android.AndroidEntryPoint

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.replaceFragment(R.id.mainFragmentContainer, NoteListFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_list -> {
                    childFragmentManager.replaceFragment(
                        R.id.mainFragmentContainer, NoteListFragment()
                    )
                    true
                }

                R.id.item_search -> {
                    childFragmentManager.replaceFragment(
                        R.id.mainFragmentContainer, SearchNoteFragment()
                    )
                    true
                }

                R.id.item_bookmark -> {
                    childFragmentManager.replaceFragment(
                        R.id.mainFragmentContainer, BookmarkFragment()
                    )
                    true
                }

                R.id.item_profile -> {
                    childFragmentManager.replaceFragment(
                        R.id.mainFragmentContainer, UserProfileFragment()
                    )
                    true
                }

                else -> false
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}