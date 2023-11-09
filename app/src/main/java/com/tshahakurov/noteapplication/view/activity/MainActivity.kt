package com.tshahakurov.noteapplication.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.util.Util
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

//    override fun onBackPressed() {
//        super.onBackPressed()
//        if (Util.isLogin){
//            supportFragmentManager.popBackStack()
//            Util.isLogin = false
//        }
//    }
}