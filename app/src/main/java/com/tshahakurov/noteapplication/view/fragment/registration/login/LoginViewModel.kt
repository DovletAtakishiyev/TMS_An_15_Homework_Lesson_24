package com.tshahakurov.noteapplication.view.fragment.registration.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepo
import com.tshahakurov.noteapplication.util.isEmailValid

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferencesRepo = SharedPreferencesRepo(application.applicationContext)
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun validateUser(): Boolean {
        return if (isEmailValid() && isPasswordIsValid()) {
            sharedPreferencesRepo.setUserEmail(email.value.toString())
            sharedPreferencesRepo.setAccount()
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
