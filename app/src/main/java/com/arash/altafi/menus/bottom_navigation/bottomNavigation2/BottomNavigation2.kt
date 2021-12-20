package com.arash.altafi.menus.bottom_navigation.bottomNavigation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_bottom_navigation2.*

class BottomNavigation2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation2)

        bottomBar2.setActiveItem(0)
        bottomBar2.setBadge(2)
        bottomBar2.removeBadge(2)

        bottomBar2.onItemSelected = {
            status.text = "Item $it selected"
        }

        bottomBar2.onItemReselected = {
            status.text = "Item $it re-selected"
        }

        bottomBar2.onItemLongClick = {
            status.text = "Item $it long click"
        }

    }
}