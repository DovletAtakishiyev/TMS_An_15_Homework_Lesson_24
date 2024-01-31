package com.tshahakurov.noteapplication.view.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.main.MainFragment
import com.tshahakurov.noteapplication.view.fragment.onboard.onboarding.OnboardingFragment
import com.tshahakurov.noteapplication.view.fragment.splash.SplashFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.replaceFragment(
            R.id.fragmentContainer, SplashFragment()
        )

        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.replaceFragment(
                R.id.fragmentContainer,
                if (viewModel.hasAccount()) MainFragment()
                else OnboardingFragment()
            )
        }, 1000L)

    }
}
