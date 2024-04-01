package com.tshahakurov.noteapplication.view.fragment.onboard.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentOnboardingBinding

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
                findNavController().navigate(
                    R.id.action_onboardingFragment_to_onboardingViewPagerFragment
                )
            }

            loginButtonText.setOnClickListener {
                findNavController().navigate(
                    R.id.action_onboardingFragment_to_loginFragment
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}