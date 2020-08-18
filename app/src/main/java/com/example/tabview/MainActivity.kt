package com.example.tabview

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabs = findViewById<TabLayout>(R.id.tlTabs)
        val view = findViewById<ViewPager>(R.id.vpView)

        //  FILL TAB WITH ITEMS
        tabs.addTab(tabs.newTab().setText("Home"))
        tabs.addTab(tabs.newTab().setText("Favourites"))
        tabs.addTab(tabs.newTab().setText("Search"))
        tabs.tabGravity = TabLayout.GRAVITY_FILL

        //FILL TAB WITH ICONS
        tabs.getTabAt(0)?.setIcon(R.drawable.ic_home)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_favorites)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_search)

        //GET THE ADAPTER
        val adapter = TabAdapter(this, supportFragmentManager, tabs.tabCount)
        view.adapter = adapter

        //SET CURRENT TAB
        view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onTabSelected(tab: TabLayout.Tab) {
                view.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}