package com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.arash.altafi.menus.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_bar_layout1.*

class TabBarLayout1 : AppCompatActivity() {

    private var adapter : FragmentAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_bar_layout1)

        val fm : FragmentManager = supportFragmentManager
        adapter = FragmentAdapter(fm , lifecycle)
        view_pager_1.adapter = adapter

        tab_layout_1.addTab(tab_layout_1.newTab().setText("صرافی ملی").setIcon(R.drawable.chart_dollar))
        tab_layout_1.addTab(tab_layout_1.newTab().setText("بازار آزاد").setIcon(R.drawable.ic_baseline_attach_money_24))
        tab_layout_1.addTab(tab_layout_1.newTab().setText("بانک مرکزی").setIcon(R.drawable.bank_markazi))

        tab_layout_1.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager_1.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        view_pager_1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tab_layout_1.selectTab(tab_layout_1.getTabAt(position))
            }
        })

    }
}