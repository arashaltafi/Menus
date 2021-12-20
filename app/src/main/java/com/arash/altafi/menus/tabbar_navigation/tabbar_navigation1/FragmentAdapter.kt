package com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        when (position) {
            1 -> return Fragment2()
            2 -> return Fragment3()
            else -> ""
        }
        return Fragment1()
    }

}