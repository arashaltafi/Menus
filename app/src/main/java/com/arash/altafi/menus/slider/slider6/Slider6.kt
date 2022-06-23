package com.arash.altafi.menus.slider.slider6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_slider6.*

class Slider6 : AppCompatActivity() {

    private lateinit var adapter6: SliderAdapter6
    private var photo6: ArrayList<Photo6> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider6)

        init()
    }

    private fun init() {

        photo6.add(Photo6(1, R.drawable.test1, "test 1", "www.arashaltafi.ir"))
        photo6.add(Photo6(2, R.drawable.test2, "test 2", "www.arashaltafi.ir"))
        photo6.add(Photo6(3, R.drawable.test3, "test 3", "www.arashaltafi.ir"))
        photo6.add(Photo6(4, R.drawable.test4, "test 4", "www.arashaltafi.ir"))
        photo6.add(Photo6(5, R.drawable.test5, "test 5", "www.arashaltafi.ir"))


        adapter6 = SliderAdapter6(photo6)
        slider6.adapter = adapter6
        slider6.clipToPadding = false
        slider6.pageMargin = 25
        slider6.setPadding(45, 0, 10, 0)
        slider6.currentItem = 1
    }

}