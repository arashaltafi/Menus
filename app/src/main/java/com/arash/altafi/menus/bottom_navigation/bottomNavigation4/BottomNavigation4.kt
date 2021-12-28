package com.arash.altafi.menus.bottom_navigation.bottomNavigation4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.arash.altafi.menus.R
import com.arash.altafi.menus.bottom_navigation.bottomNavigation4.fragment.*
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment1
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment2
import com.arash.altafi.menus.tabbar_navigation.tabbar_navigation1.Fragment3
import kotlinx.android.synthetic.main.activity_bottom_navigation5.*

class BottomNavigation4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation5)

        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {

        //add the fragments you want to display in a List
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(Fragment_1_Bottom_Navigation_4())
        fragmentList.add(Fragment_2_Bottom_Navigation_4())
        fragmentList.add(Fragment_3_Bottom_Navigation_4())
        fragmentList.add(Fragment_4_Bottom_Navigation_4())
        fragmentList.add(Fragment_5_Bottom_Navigation_4())


        //we need the savedInstanceState to get the position
        spaceTabLayout.initialize(viewPager_navigation_4, supportFragmentManager, fragmentList, savedInstanceState)

        // For Insert icon in backend
//        spaceTabLayout.setTabOneIcon(R.drawable.ic_tab_one)
//        spaceTabLayout.setTabTwoIcon(R.drawable.ic_tab_two)
//        spaceTabLayout.setTabThreeIcon(R.drawable.ic_tab_three)
//        spaceTabLayout.setTabFourIcon(R.drawable.ic_tab_four)
//        spaceTabLayout.setTabFiveIcon(R.drawable.ic_tab_five)

        Toast.makeText(this , "${spaceTabLayout.currentPosition}" , Toast.LENGTH_SHORT).show()

    }

    //we need the outState to save the position
    override fun onSaveInstanceState (outState : Bundle) {
        spaceTabLayout.saveState(outState)
        super.onSaveInstanceState(outState)
    }

}