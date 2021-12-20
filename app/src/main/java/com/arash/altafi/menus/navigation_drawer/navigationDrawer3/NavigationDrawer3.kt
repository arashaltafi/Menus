package com.arash.altafi.menus.navigation_drawer.navigationDrawer3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_navigation_drawer3.*

class NavigationDrawer3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer3)

        img_menu.setOnClickListener {
            drawerlayout3.openMenu(true)
        }
    }

    override fun onBackPressed() {
        if (drawerlayout3.isMenuVisible) {
            drawerlayout3.closeMenu(true)
        } else {
            super.onBackPressed()
        }
    }

}