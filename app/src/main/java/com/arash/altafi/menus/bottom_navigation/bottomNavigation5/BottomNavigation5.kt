package com.arash.altafi.menus.bottom_navigation.bottomNavigation5

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.*
import androidx.viewpager2.widget.ViewPager2
import com.arash.altafi.menus.R
import com.arash.altafi.menus.bottom_navigation.bottomNavigation4.fragment.*
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener
import kotlinx.android.synthetic.main.activity_bottom_navigation6.*

class BottomNavigation5 : AppCompatActivity() {

    private var fragment1BottomNavigation1 : Fragment_1_Bottom_Navigation_4 = Fragment_1_Bottom_Navigation_4()
    private var fragment1BottomNavigation2 : Fragment_2_Bottom_Navigation_4 = Fragment_2_Bottom_Navigation_4()
    private var fragment1BottomNavigation3 : Fragment_3_Bottom_Navigation_4 = Fragment_3_Bottom_Navigation_4()
    private var fragment1BottomNavigation4 : Fragment_4_Bottom_Navigation_4 = Fragment_4_Bottom_Navigation_4()
    private var fragment1BottomNavigation5 : Fragment_5_Bottom_Navigation_4 = Fragment_5_Bottom_Navigation_4()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation6)

        bottom_navigation_5.defaultItem = 0
        val typeface = Typeface.createFromAsset(assets, "vazir.ttf")
        bottom_navigation_5.typeface = typeface
        bottom_navigation_5.setOnSelectedItemChangeListener(OnSelectedItemChangeListener { i ->
            when (i) {
                R.id.tab_one -> {
                    if (fragment1BottomNavigation1 == null) {
                        fragment1BottomNavigation1 = Fragment_1_Bottom_Navigation_4()
                    }
                    replaceTransaction(fragment1BottomNavigation1)
                }
                R.id.tab_two -> {
                    if (fragment1BottomNavigation2 == null) {
                        fragment1BottomNavigation2 = Fragment_2_Bottom_Navigation_4()
                    }
                    replaceTransaction(fragment1BottomNavigation2)
                }
                R.id.tab_three -> {
                    if (fragment1BottomNavigation3 == null) {
                        fragment1BottomNavigation3 = Fragment_3_Bottom_Navigation_4()
                    }
                    replaceTransaction(fragment1BottomNavigation3)
                }
                R.id.tab_four -> {
                    if (fragment1BottomNavigation4 == null) {
                        fragment1BottomNavigation4 = Fragment_4_Bottom_Navigation_4()
                    }
                    replaceTransaction(fragment1BottomNavigation4)
                }
                R.id.tab_five -> {
                    if (fragment1BottomNavigation5 == null) {
                        fragment1BottomNavigation5 = Fragment_5_Bottom_Navigation_4()
                    }
                    replaceTransaction(fragment1BottomNavigation5)
                }
            }
        })
    }

    private fun replaceTransaction(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container_navigation_5, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (bottom_navigation_5.selectedItem == 0) {
            finish()
        } else {
            bottom_navigation_5.selectedItem = 0
        }
    }

}