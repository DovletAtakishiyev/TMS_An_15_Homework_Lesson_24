package com.tshahakurov.noteapplication.view.fragment.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepo

class SplashViewModel(application: Application) : AndroidViewModel(application) {
    private val spRepository = SharedPreferencesRepo(application.applicationContext)

    fun hasAccount() = spRepository.hasAccount()
}