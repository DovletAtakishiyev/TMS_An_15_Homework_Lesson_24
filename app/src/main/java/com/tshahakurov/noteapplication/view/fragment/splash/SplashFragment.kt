package com.tshahakurov.noteapplication.view.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.onboarding.OnboardingFragment

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            parentFragmentManager.replaceFragment(R.id.fragmentContainer, OnboardingFragment())
        }, 1000L)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}