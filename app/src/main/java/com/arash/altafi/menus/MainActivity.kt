package com.arash.altafi.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.bottom_navigation.bottomNavigation1.BottomNavigation1
import com.arash.altafi.menus.bottom_navigation.bottomNavigation2.BottomNavigation2
import com.arash.altafi.menus.bottom_navigation.bottomNavigation3.BottomNavigation3
import com.arash.altafi.menus.bottom_navigation.bottomNavigation4.BottomNavigation4
import com.arash.altafi.menus.bottom_navigation.bottomNavigation5.BottomNavigation5
import com.arash.altafi.menus.bottom_sheet.bottomSheet1.BottomSheet1
import com.arash.altafi.menus.bottom_sheet.bottomSheet2.BottomSheet2
import com.arash.altafi.menus.bottom_sheet.bottomSheet3.BottomSheet3
import com.arash.altafi.menus.bottom_sheet.bottomSheet4.BottomSheet4
import com.arash.altafi.menus.bottom_sheet.bottomSheet5.BottomSheet5
import com.arash.altafi.menus.coordinator.CoordinatorLayout1
import com.arash.altafi.menus.filter.filter1.FilterActivity1
import com.arash.altafi.menus.navigation_drawer.navigationDrawer1.NavigationDrawer1
import com.arash.altafi.menus.navigation_drawer.navigationDrawer2.NavigationDrawer2
import com.arash.altafi.menus.navigation_drawer.navigationDrawer3.NavigationDrawer3
import com.arash.altafi.menus.navigation_drawer.navigationDrawer4.NavigationDrawer4
import com.arash.altafi.menus.slider.slider1.Slider1
import com.arash.altafi.menus.slider.slider2.Slider2
import com.arash.altafi.menus.slider.slider3.Slider3
import com.arash.altafi.menus.slider.slider4.Slider4
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.TabBarLayout1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        // navigation drawer

        btn_navigation_drawer_1.setOnClickListener {
            startActivity(Intent(this , NavigationDrawer1::class.java))
        }

        btn_navigation_drawer_2.setOnClickListener {
            startActivity(Intent(this , NavigationDrawer2::class.java))
        }

        btn_navigation_drawer_3.setOnClickListener {
            startActivity(Intent(this , NavigationDrawer3::class.java))
        }

        btn_navigation_drawer_4.setOnClickListener {
            startActivity(Intent(this , NavigationDrawer4::class.java))
        }


        // bottom navigation


        btn_bottom_navigation_1.setOnClickListener {
            startActivity(Intent(this , BottomNavigation1::class.java))
        }

        btn_bottom_navigation_2.setOnClickListener {
            startActivity(Intent(this , BottomNavigation2::class.java))
        }


        btn_bottom_navigation_3.setOnClickListener {
            startActivity(Intent(this , BottomNavigation3::class.java))
        }


        btn_bottom_navigation_4.setOnClickListener {
            startActivity(Intent(this , BottomNavigation4::class.java))
        }


        btn_bottom_navigation_5.setOnClickListener {
            startActivity(Intent(this , BottomNavigation5::class.java))
        }


        // Slider


        btn_slider_1.setOnClickListener {
            startActivity(Intent(this , Slider1::class.java))
        }

        btn_slider_2.setOnClickListener {
            startActivity(Intent(this , Slider2::class.java))
        }


        btn_slider_3.setOnClickListener {
            startActivity(Intent(this , Slider3::class.java))
        }


        btn_slider_4.setOnClickListener {
            startActivity(Intent(this , Slider4::class.java))
        }

        // tab bar layout

        btn_tab_bar_layout_1.setOnClickListener {
            startActivity(Intent(this , TabBarLayout1::class.java))
        }

        // Coordinator layout

        btn_coordinator_layout_1.setOnClickListener {
            startActivity(Intent(this , CoordinatorLayout1::class.java))
        }

        // bottom sheet

        btn_bottom_sheet_layout_1.setOnClickListener {
            startActivity(Intent(this , BottomSheet1::class.java))
        }

        btn_bottom_sheet_layout_2.setOnClickListener {
            startActivity(Intent(this , BottomSheet2::class.java))
        }

        btn_bottom_sheet_layout_3.setOnClickListener {
            startActivity(Intent(this , BottomSheet3::class.java))
        }

        btn_bottom_sheet_layout_4.setOnClickListener {
            startActivity(Intent(this , BottomSheet4::class.java))
        }

        btn_bottom_sheet_layout_5.setOnClickListener {
            startActivity(Intent(this , BottomSheet5::class.java))
        }

        btn_filter_1.setOnClickListener {
            startActivity(Intent(this , FilterActivity1::class.java))
        }

    }

}