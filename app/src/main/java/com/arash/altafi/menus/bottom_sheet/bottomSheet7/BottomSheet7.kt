package com.arash.altafi.menus.bottom_sheet.bottomSheet7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.arash.altafi.menus.R
import com.arash.altafi.menus.bottom_sheet.bottomSheet7.navcontroller.NavControllerActivity
import com.arash.altafi.menus.bottom_sheet.bottomSheet7.viewpager.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_bottom_sheet7.*
import nl.joery.animatedbottombar.AnimatedBottomBar

class BottomSheet7 : AppCompatActivity() {

    private lateinit var bottomBars: Array<AnimatedBottomBar>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet7)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initToolbar()
        initBottomBars()
        init()
    }

    private fun init() {
        select.setOnClickListener {
            for (bottomBar in bottomBars) {
                bottomBar.addTabAt(
                    0,
                    bottom_bar.createTab(nl.joery.animatedbottombar.R.drawable.alarm, R.string.app_name)
                )
            }
        }

        deselect.setOnClickListener {
            for (bottomBar in bottomBars) {
                if (bottomBar.tabCount > 0) {
                    val tab = bottomBar.tabs.last()
                    bottomBar.removeTab(tab)
                }
            }
        }

        select_first.setOnClickListener {
            for (bottomBar in bottomBars) {
                bottomBar.selectTabAt(0)
            }
        }

        select_last.setOnClickListener {
            for (bottomBar in bottomBars) {
                bottomBar.selectTabAt(bottom_bar.tabCount - 1)
            }
        }

        open_nav_controller.setOnClickListener {
            startActivity(Intent(this, NavControllerActivity::class.java))
        }

        open_view_pager.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnApplyWindowInsetsListener { _, insets ->
            toolbar.setPadding(
                toolbar.paddingLeft,
                toolbar.paddingTop + insets.systemWindowInsetTop,
                toolbar.paddingRight,
                toolbar.paddingBottom
            )
            insets.consumeSystemWindowInsets()
        }
    }

    private fun initBottomBars() {
        bottomBars = arrayOf(bottom_bar, bottom_bar2, bottom_bar3, bottom_bar4, bottom_bar5)

        bottomBars.forEach {
            it.setBadgeAtTabIndex(1, AnimatedBottomBar.Badge("99"))
        }

        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                Log.d("TAB_SELECTED", "Selected index: $newIndex, title: ${newTab.title}")
            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                Log.d("TAB_RESELECTED", "Reselected index: $index, title: ${tab.title}")
            }
        })
    }

}