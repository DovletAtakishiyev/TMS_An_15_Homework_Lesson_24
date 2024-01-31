package com.tshahakurov.noteapplication.view.fragment.main.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.tshahakurov.noteapplication.R

class LogoutDialog(val onLogout: () -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.logout_dialog))
            .setPositiveButton(getString(R.string.choice_yes)) { _, _ ->
                onLogout()
                Log.wtf("suita", "logged out")
            }
            .setNegativeButton(getString(R.string.choice_no)) { _, _ ->
                Log.wtf("suita", "canceled")
            }
            .create()
}