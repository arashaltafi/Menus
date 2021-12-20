package com.arash.altafi.menus.navigation_drawer.navigationDrawer4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arash.altafi.menus.R
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class NavigationDrawer4 : AppCompatActivity(), View.OnClickListener {

    private lateinit var drawerLayout: DuoDrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var textH: TextView
    private lateinit var textP: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer4)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        toolbar = findViewById(R.id.toolbar4)
        setSupportActionBar(toolbar)
        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        drawerLayout = findViewById(R.id.drawer4)

        replace(HomeFragment())

        initDrawer()
    }

    private fun initDrawer() {
        val drawerToggle = DuoDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()
        val contentView: View = drawerLayout.contentView
        val menuView: View = drawerLayout.menuView
        textH = menuView.findViewById(R.id.hello)
        textP = menuView.findViewById(R.id.profile)
        textH.setOnClickListener(this)
        textP.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.hello -> {
                replace(HomeFragment(),"Home")
                Toast.makeText(this, "Hello Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.profile -> {
                replace(HomeFragment(),"Profile")
                Toast.makeText(this , "Profile Clicked" , Toast.LENGTH_SHORT).show()
            }
            else -> {
                replace(HomeFragment(),"Home")
            }
        }
        drawerLayout.closeDrawer()
    }

    private fun replace(fragment: Fragment, s: String) {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerF, fragment )
        transaction.addToBackStack(s)
        transaction.commit()
    }

    private fun replace(fragment: Fragment) {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerF, fragment )
        transaction.commit()
    }

}