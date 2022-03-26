package com.arash.altafi.menus.filter.filter1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R

class FilterActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter1)

        supportFragmentManager.beginTransaction().replace(R.id.frame_container, MainFragment()).addToBackStack("MainActivity").commit()

    }
}