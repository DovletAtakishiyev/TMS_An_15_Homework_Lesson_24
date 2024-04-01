package com.tshahakurov.noteapplication.view.fragment.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.databinding.FragmentUserProfileBinding
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import com.tshahakurov.noteapplication.view.fragment.main.dialog.LogoutDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileFragment : Fragment() {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = viewModel.getUser()

        binding.composeProfile.setContent {
            if (user != null) {
                ProfileScreen(user = user) {
                    LogoutDialog {
//                        parentFragment?.parentFragmentManager?.replaceFragment(
//                            R.id.fragmentContainer, OnboardingFragment()
//                        )
                        viewModel.logout()
                    }.show(childFragmentManager, "suita")
                }
            } else {
                Text(text = SharedPreferencesRepository(requireContext()).getUserEmail() ?: "n/a")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}