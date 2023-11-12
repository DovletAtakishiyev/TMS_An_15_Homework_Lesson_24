package com.tshahakurov.noteapplication.view.fragment.onboard.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val list = arrayListOf(
        ViewPagerStepFragment.getStep(STEP_1),
        ViewPagerStepFragment.getStep(STEP_2),
        ViewPagerStepFragment.getStep(STEP_3),
    )

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment = list[position]
}