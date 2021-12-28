package com.arash.altafi.menus.bottom_navigation.bottomNavigation3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_bottom_navigation4.*

class BottomNavigation3 : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation4)

        navController = findNavController(R.id.fragmentContainerView)
        setupActionBarWithNavController(navController)
        setupSmoothBottomMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.another_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.another_item_1 -> {
                Toast.makeText(this , "Another Menu Item 1 Selected" , Toast.LENGTH_SHORT).show()
            }

            R.id.another_item_2 -> {
                Toast.makeText(this, "Another Menu Item 2 Selected", Toast.LENGTH_SHORT).show()
            }

            R.id.another_item_3 -> {
                Toast.makeText(this, "Another Menu Item 3 Selected", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.menu_bottom_3)
        val menu = popupMenu.menu
        bottomBar_3.setupWithNavController(menu, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}