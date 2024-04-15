package com.sistemexico.schoolmanager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.ChatFragment
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.PayFragment
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.ProfileFragment

class AdapterViewPagerLogged(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChatFragment()
            1 -> ProfileFragment()
            2 -> PayFragment()
            else -> {
                throw IllegalStateException("Unexpected position $position")
            }
        }
    }
}
