package com.arash.altafi.menus.slider.slider4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.menus.R

class SecondSlider4 : AppCompatActivity() {

    private lateinit var id : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_slider4)

        init()
    }

    private fun init() {

        id = intent.getStringExtra("id")!!

        Toast.makeText(this , "id: $id" , Toast.LENGTH_SHORT).show()

    }

}