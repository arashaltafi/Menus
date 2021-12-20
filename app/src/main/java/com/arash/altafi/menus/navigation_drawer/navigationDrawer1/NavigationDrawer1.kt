package com.arash.altafi.menus.navigation_drawer.navigationDrawer1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.arash.altafi.menus.R
import com.shreyaspatil.material.navigationview.MaterialNavigationView
import kotlinx.android.synthetic.main.activity_navigation_drawer1.*
import kotlinx.android.synthetic.main.app_bar_main.*

class NavigationDrawer1 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer1)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)

        // Show ItemStyle
        println("ItemStyle=${nav_view.getItemStyle()}")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_default -> {
                nav_view.setItemStyle(MaterialNavigationView.ITEM_STYLE_DEFAULT)
            }
            R.id.action_round_rect -> {
                nav_view.setItemStyle(MaterialNavigationView.ITEM_STYLE_ROUND_RECTANGLE)
            }
            R.id.action_round_right -> {
                nav_view.setItemStyle(MaterialNavigationView.ITEM_STYLE_ROUND_RIGHT)
            }
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}