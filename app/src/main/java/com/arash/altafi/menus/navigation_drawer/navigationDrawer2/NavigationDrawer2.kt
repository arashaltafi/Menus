package com.arash.altafi.menus.navigation_drawer.navigationDrawer2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_navigation_drawer2.*

class NavigationDrawer2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer2)

        // toolbar
        setSupportActionBar(findViewById(R.id.toolbar2))

        // nav menu select listener
        listener()

        // icon menu
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        drawerToggle.drawerArrowDrawable.color = Color.WHITE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun listener() {
        navigation_view.setNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this , "Home" , Toast.LENGTH_SHORT).show()
//                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this , "Gallery" , Toast.LENGTH_SHORT).show()
//                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_slideshow -> {
                    Toast.makeText(this , "Slide Show" , Toast.LENGTH_SHORT).show()
                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_tools -> {
                    Toast.makeText(this , "Tools" , Toast.LENGTH_SHORT).show()
                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_share -> {
                    Toast.makeText(this , "Share" , Toast.LENGTH_SHORT).show()
                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_send -> {
                    Toast.makeText(this , "Send" , Toast.LENGTH_SHORT).show()
                    drawer.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}