package com.tshahakurov.noteapplication.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.util.replaceFragmentWithStack
import com.tshahakurov.noteapplication.view.fragment.splash.SplashFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.replaceFragmentWithStack(
            R.id.fragmentContainer,
            SplashFragment()
        )
    }
}