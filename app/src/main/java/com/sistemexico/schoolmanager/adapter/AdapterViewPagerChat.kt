package com.sistemexico.schoolmanager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.ChatFragment
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments.LiveChatsFragment
import com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments.NotificationsFragment

class AdapterViewPagerChat(activity: ChatFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NotificationsFragment()
            1 -> LiveChatsFragment()
            else -> {
                throw IllegalStateException("Unexpected position $position")
            }
        }
    }
}