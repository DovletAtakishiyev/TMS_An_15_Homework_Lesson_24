package com.tshahakurov.noteapplication.view.fragment.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tshahakurov.noteapplication.databinding.FragmentUserProfileBinding
import dagger.hilt.android.AndroidEntryPoint

class UserProfileFragment : Fragment() {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}