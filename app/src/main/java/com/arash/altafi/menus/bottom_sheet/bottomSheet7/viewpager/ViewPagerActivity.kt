package com.arash.altafi.menus.bottom_sheet.bottomSheet7.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        initToolbar()

        view_pager.adapter =
            ViewPager2Adapter(
                supportFragmentManager,
                lifecycle
            )
        bottom_bar.setupWithViewPager2(view_pager)
        bottom_bar.apply {
            onTabSelected = {
                Log.i("ViewPagerActivity", "onTabSelected: ${it.title}")
            }
            onTabReselected = {
                Log.i("ViewPagerActivity", "onTabReselected: ${it.title}")
            }
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

    class ViewPager2Adapter(
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
    ) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return SampleFragment.newInstance(position)
        }
    }
}