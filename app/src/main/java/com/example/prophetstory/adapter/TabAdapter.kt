package com.example.prophetstory.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.prophetstory.fragment.NabiFragment
import com.example.prophetstory.fragment.RasulFragment

class TabAdapter(fragmentManager : FragmentManager, lifecyle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecyle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NabiFragment()
            }
            1 -> {
                RasulFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}