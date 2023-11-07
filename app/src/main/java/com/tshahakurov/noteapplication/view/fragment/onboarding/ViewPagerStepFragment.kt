package com.tshahakurov.noteapplication.view.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentOnboardingStepBinding

const val STEP_1 = 1
const val STEP_2 = 2
const val STEP_3 = 3
const val STEP_KEY = "step"

class ViewPagerStepFragment : Fragment() {
    private var _binding: FragmentOnboardingStepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt(STEP_KEY)?.run {
            binding.pagerItemImage.setImageResource(
                when (this) {
                    STEP_1 -> R.drawable.ic_work
                    STEP_2 -> R.drawable.ic_shop
                    STEP_3 -> R.drawable.ic_location
                    else -> throw IllegalStateException()
                }
            )
            binding.pagerItemText.setText(
                when (this) {
                    STEP_1 -> R.string.first_step
                    STEP_2 -> R.string.second_step
                    else -> R.string.third_step
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun getStep(step: Int): ViewPagerStepFragment {
            return ViewPagerStepFragment().apply {
                arguments = bundleOf(STEP_KEY to step)
            }
        }
    }
}