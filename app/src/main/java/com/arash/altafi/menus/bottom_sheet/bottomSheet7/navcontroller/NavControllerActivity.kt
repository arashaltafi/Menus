package com.arash.altafi.menus.bottom_sheet.bottomSheet7.navcontroller

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_nav_controller.*

class NavControllerActivity : AppCompatActivity(R.layout.activity_nav_controller) {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.main_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.clock_tabs, menu)
        bottom_bar.setupWithNavController(menu!!, navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }
}