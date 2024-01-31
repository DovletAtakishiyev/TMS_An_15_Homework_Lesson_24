package com.tshahakurov.noteapplication.view.fragment.onboard.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentOnboardingBinding
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.util.replaceFragmentWithStack
import com.tshahakurov.noteapplication.view.fragment.onboard.registration.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            discoverButton.setOnClickListener {
                parentFragmentManager.replaceFragmentWithStack(
                    R.id.fragmentContainer, OnboardingViewPagerFragment()
                )
            }

            loginButtonText.setOnClickListener {
                parentFragmentManager.replaceFragmentWithStack(
                    R.id.fragmentContainer, LoginFragment()
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}