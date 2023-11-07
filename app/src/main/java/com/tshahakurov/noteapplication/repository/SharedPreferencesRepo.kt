package com.tshahakurov.noteapplication.repository

import android.content.Context
import androidx.core.content.edit

const val APP_SHARED_PREF = "app_shared_pref"
const val HAS_ACCOUNT = "was_logged"

const val USER_SHARED_PREF = "user_shared_pref"
const val USER_FIRST_NAME = "user_first_name"
const val USER_LAST_NAME = "user_last_name"
const val USER_EMAIL = "user_email"

class SharedPreferencesRepo(context: Context) {

    // -- -- -- App Preferences  -- -- -- //
    private val appPreferences = context.getSharedPreferences(
        APP_SHARED_PREF, Context.MODE_PRIVATE
    )

    fun hasAccount() = appPreferences.getBoolean(HAS_ACCOUNT, false)

    fun setAccount() {
        appPreferences.edit {
            putBoolean(HAS_ACCOUNT, true)
        }
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