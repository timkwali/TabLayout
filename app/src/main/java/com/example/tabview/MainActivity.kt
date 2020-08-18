package com.example.tabview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        //GET THE ADAPTER
        val adapter = TabAdapter(this, supportFragmentManager, tabs.tabCount)
        view.adapter = adapter

        //
        view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}