package com.tshahakurov.noteapplication.view.fragment.registration.signin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepo
import com.tshahakurov.noteapplication.util.isEmailValid

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferencesRepo = SharedPreferencesRepo(application.applicationContext)
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun validateUser(): Boolean {
        return if (isEmailValid() && isFirstNameValid() && isLastNameValid() && isPasswordValid()) {
            sharedPreferencesRepo.setUserEmail(email.value.toString())
            sharedPreferencesRepo.setUserFirstName(firstName.value.toString())
            sharedPreferencesRepo.setUserLastName(lastName.value.toString())
            sharedPreferencesRepo.setAccount()
            return true
        } else false
    }

    private fun isEmailValid(): Boolean = email.value?.isEmailValid()!!

    private fun isFirstNameValid(): Boolean = !firstName.value.isNullOrBlank()

    private fun isLastNameValid(): Boolean = !lastName.value.isNullOrBlank()

    private fun isPasswordValid(): Boolean = !password.value.isNullOrBlank()

}