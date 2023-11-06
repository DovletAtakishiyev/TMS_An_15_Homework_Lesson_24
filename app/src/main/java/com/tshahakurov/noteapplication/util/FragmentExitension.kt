package com.tshahakurov.noteapplication.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(containerId: Int, fragment: Fragment) {
    beginTransaction()
        .replace(containerId, fragment)
        .commit()
}

fun FragmentManager.replaceFragmentWithStack(
    containerId: Int,
    fragment: Fragment,
    tag: String? = ""
) {
    beginTransaction()
        .replace(containerId, fragment)
        .addToBackStack(tag)
        .commit()
}