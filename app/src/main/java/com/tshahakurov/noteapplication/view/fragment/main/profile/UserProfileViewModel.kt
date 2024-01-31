package com.tshahakurov.noteapplication.view.fragment.main.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.noteapplication.model.User
import com.tshahakurov.noteapplication.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val repository: SharedPreferencesRepository
) : ViewModel() {

    private val currentUser = MutableLiveData<User>()

    fun getUser(): User? {
        currentUser.value = repository.getUser()
        return currentUser.value
    }

    fun logout(){
        repository.logout()
    }
}