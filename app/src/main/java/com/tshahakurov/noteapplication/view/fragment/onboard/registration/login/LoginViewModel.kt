package com.tshahakurov.noteapplication.view.fragment.onboard.registration.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import com.tshahakurov.noteapplication.util.isEmailValid

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferencesRepository = SharedPreferencesRepository(application.applicationContext)
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun validateUser(): Boolean {
        return if (isEmailValid() && isPasswordIsValid()) {
            sharedPreferencesRepository.setUserEmail(email.value.toString())
            sharedPreferencesRepository.setLoggedIn()
            true
        } else false
    }

    private fun isEmailValid(): Boolean {
        return email.value?.isEmailValid()!!
    }

    private fun isPasswordIsValid(): Boolean {
        return !password.value.isNullOrBlank()
    }
}
