package com.tshahakurov.noteapplication.view.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val spRepository: SharedPreferencesRepository,
    application: Application
) : AndroidViewModel(application) {
//     = SharedPreferencesRepo(application.applicationContext)

    fun hasAccount() = spRepository.wasLoggedIn()
}