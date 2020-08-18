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

    var tabs: TabLayout? = null
    var view: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabs = findViewById<TabLayout>(R.id.tbTabs)
        var view = findViewById<ViewPager>(R.id.vpView)

        tabs!!.addTab(tabs!!.newTab().setText("Home"))
        tabs!!.addTab(tabs!!.newTab().setText("Favourites"))
        tabs!!.addTab(tabs!!.newTab().setText("Search"))
        tabs!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(this, supportFragmentManager, tabs!!.tabCount)
        view!!.adapter = adapter

        view!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })




//        var tabView = findViewById<TabLayout.TabView>(R.id.tabLayout)
//        var homeTab = findViewById<TabItem>(R.id.homeTab)
//        var favouritesTab = findViewById<TabItem>(R.id.favoritesTab)
//        var searchTab = findViewById<TabItem>(R.id.searchTab)
//        var viewTab = findViewById<ViewPager>(R.id.viewPager)
//
//        val tabAdapter: TabAdapter = TabAdapter(this, supportFragmentManager, tabView.childCount)
//        viewTab.adapter = tabAdapter





//        fun resetColor(){
//            //RESET ALL BUTTONS COLOR TO DECAGON GREEN
//            DrawableCompat.setTint(homeTab.icon, ContextCompat.getColor(this, R.color.decagonGreen))
//            DrawableCompat.setTint(favouritesTab.icon, ContextCompat.getColor(this, R.color.decagonGreen))
//            DrawableCompat.setTint(searchTab.icon, ContextCompat.getColor(this, R.color.decagonGreen))
//        }
//        resetColor()

    }
}