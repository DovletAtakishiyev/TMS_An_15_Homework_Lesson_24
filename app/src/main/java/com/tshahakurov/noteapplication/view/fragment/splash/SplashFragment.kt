package com.tshahakurov.noteapplication.view.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    @Inject         // Tak navernoye lu4we ne delat', nu da ladno
    lateinit var sharedPreferenceRepo: SharedPreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(
                if (sharedPreferenceRepo.wasLoggedIn())
                    R.id.action_splashFragment_to_mainFragment
                else
                    R.id.action_splashFragment_to_onboardingFragment
            )
        }, 1000L)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}