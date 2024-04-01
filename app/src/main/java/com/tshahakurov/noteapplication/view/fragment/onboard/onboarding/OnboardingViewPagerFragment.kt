package com.tshahakurov.noteapplication.view.fragment.onboard.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentOnboardingViewPagerBinding

class OnboardingViewPagerFragment : Fragment() {

    private var _binding: FragmentOnboardingViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewPager.adapter = ViewPagerAdapter(childFragmentManager)
            circleIndicator.setViewPager(viewPager)

            skipButtonText.setOnClickListener {
                findNavController().navigate(
                    R.id.action_onboardingViewPagerFragment_to_loginFragment
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}