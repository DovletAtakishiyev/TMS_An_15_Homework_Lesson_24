package com.tshahakurov.noteapplication.view.fragment.main.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.tshahakurov.noteapplication.R


class DeleteDialog(val onDelete: () -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.delete_dialog))
            .setPositiveButton(getString(R.string.choice_yes)) { _, _ ->
                onDelete()
                Log.wtf("suita", "delete")
            }
            .setNegativeButton(getString(R.string.choice_no)) { _, _ ->
                Log.wtf("suita", "not delete")
            }
            .create()
}