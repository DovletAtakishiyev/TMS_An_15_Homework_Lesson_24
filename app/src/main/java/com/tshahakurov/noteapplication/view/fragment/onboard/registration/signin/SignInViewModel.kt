package com.tshahakurov.noteapplication.view.fragment.onboard.registration.signin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import com.tshahakurov.noteapplication.util.isEmailValid

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferencesRepository = SharedPreferencesRepository(application.applicationContext)
    val firstName = MutableLiveData("")
    val lastName = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun validateUser(): Boolean {
        return if (isEmailValid() && isFirstNameValid() && isLastNameValid() && isPasswordValid()) {
            sharedPreferencesRepository.setUserEmail(email.value.toString())
            sharedPreferencesRepository.setUserFirstName(firstName.value.toString())
            sharedPreferencesRepository.setUserLastName(lastName.value.toString())
            sharedPreferencesRepository.setLoggedIn()
            return true
        } else false
    }

    private fun isEmailValid(): Boolean = email.value?.isEmailValid()!!

    private fun isFirstNameValid(): Boolean = !firstName.value.isNullOrBlank()

    private fun isLastNameValid(): Boolean = !lastName.value.isNullOrBlank()

    private fun isPasswordValid(): Boolean = !password.value.isNullOrBlank()

}