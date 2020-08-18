package com.example.tabview

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(private val cntx: Context, fm: FragmentManager, internal var allTabs: Int): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> { return HomeFragment() }
            1 -> { return FavouritesFragment() }
            else -> { return SearchFragment() }
        }
    }

    override fun getCount(): Int {
        return allTabs
    }
}