package com.tshahakurov.noteapplication.view.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.book.list.NoteListFragment
import com.tshahakurov.noteapplication.view.fragment.onboarding.OnboardingFragment

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            if (viewModel.hasAccount()){
                parentFragmentManager.replaceFragment(R.id.fragmentContainer, NoteListFragment())
            } else {
                parentFragmentManager.replaceFragment(R.id.fragmentContainer, OnboardingFragment())
            }
        }, 1000L)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}