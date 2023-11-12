package com.tshahakurov.noteapplication.view.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.main.MainFragment
import com.tshahakurov.noteapplication.view.fragment.onboard.onboarding.OnboardingFragment
import com.tshahakurov.noteapplication.view.fragment.splash.SplashFragment

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

        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}