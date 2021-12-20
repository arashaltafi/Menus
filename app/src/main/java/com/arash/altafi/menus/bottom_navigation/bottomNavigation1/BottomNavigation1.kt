package com.arash.altafi.menus.bottom_navigation.bottomNavigation1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.arash.altafi.menus.R
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment1
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment2
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment3
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation3.*
import java.util.ArrayList

class BottomNavigation1 : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    private var prevMenuItem: MenuItem ?= null

    private var fragment1 : Fragment1 ?= null
    private var fragment2 : Fragment2 ?= null
    private var fragment3 : Fragment3 ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation3)

        setUpBottomNavigation()
        viewPager_3.currentItem = 2
    }

    private fun setUpBottomNavigation() {
        bottomNavigation_3.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab_profile -> {
                    viewPager_3.currentItem = 0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.tab_pic -> {
                    viewPager_3.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
                R.id.tab_search -> {
                    viewPager_3.currentItem = 2
                    return@OnNavigationItemSelectedListener true
                }
                else -> {}
            }
            false
        })
        viewPager_3.addOnPageChangeListener(object : OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem!!.isChecked = false
                }
                else {
                    bottomNavigation_3.menu.getItem(2).isChecked = false
                }
                bottomNavigation_3.menu.getItem(position).isChecked = true
                prevMenuItem = bottomNavigation_3.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        setUpViewPager(viewPager_3)
    }

    private fun setUpViewPager(upViewPager: ViewPager) {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        fragment1 = Fragment1()
        fragment2 = Fragment2()
        fragment3 = Fragment3()

        viewPagerAdapter.addFragment(fragment1!!)
        viewPagerAdapter.addFragment(fragment2!!)
        viewPagerAdapter.addFragment(fragment3!!)
        upViewPager.adapter = viewPagerAdapter
        upViewPager.offscreenPageLimit = 2
    }

    class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        var fragments = ArrayList<Fragment>()
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment) {
            fragments.add(fragment)
        }
    }

    override fun onBackPressed() {
        if (viewPager_3.currentItem != 2) {
            viewPager_3.currentItem = 2
        }
        else {
            if (doubleBackToExitPressedOnce) {
                finish()
                return
            }
            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this , "برای خروج از برنامه بکبار دیگر کلید برگشت را فشار دهید" , Toast.LENGTH_SHORT).show()
            Handler(Looper.myLooper()!!).postDelayed(Runnable {
                doubleBackToExitPressedOnce = false
            } , 4000)
        }
    }
}