package com.tshahakurov.noteapplication.repository

import android.content.Context
import androidx.core.content.edit
import com.tshahakurov.noteapplication.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

const val APP_SHARED_PREF = "app_shared_pref"
const val LOGGED_IN = "is_logged_in"

const val USER_SHARED_PREF = "user_shared_pref"
const val USER_FIRST_NAME = "user_first_name"
const val USER_LAST_NAME = "user_last_name"
const val USER_EMAIL = "user_email"

class SharedPreferencesRepository @Inject constructor(
    @ApplicationContext context: Context
) {

    // -- -- -- App Preferences  -- -- -- //
    private val appPreferences = context.getSharedPreferences(APP_SHARED_PREF, Context.MODE_PRIVATE)

    fun wasLoggedIn() = appPreferences.getBoolean(LOGGED_IN, false)

    fun setLoggedIn() {
        appPreferences.edit { putBoolean(LOGGED_IN, true) }
    }

    // -- -- -- User Preferences -- -- -- //
    private val userPreferences = context.getSharedPreferences(
        USER_SHARED_PREF, Context.MODE_PRIVATE
    )

    fun setUserEmail(email: String) {
        userPreferences.edit {
            putString(USER_EMAIL, email)
        }
    }

    fun setUserFirstName(firstName: String) {
        userPreferences.edit {
            putString(USER_FIRST_NAME, firstName)
        }
    }

    fun setUserLastName(lastName: String) {
        userPreferences.edit {
            putString(USER_LAST_NAME, lastName)
        }
    }

    fun getUserEmail() = userPreferences.getString(USER_EMAIL, null)

    fun getUserFirstName() = userPreferences.getString(USER_FIRST_NAME, null)

    fun getUserLastName() = userPreferences.getString(USER_LAST_NAME, null)

    fun getUser() = User(
        id = 0,
        email = getUserEmail(),
        firstName = getUserFirstName(),
        lastName = getUserLastName()
    )

    // -- -- -- Clean -- -- -- //
    fun logout() {
        userPreferences.edit {
            clear()
        }
        appPreferences.edit {
            clear()
        }
    }
}