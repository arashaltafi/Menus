package com.arash.altafi.menus.slider.slider3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.arash.altafi.menus.R
import com.arash.altafi.menus.slider.slider2.Photo2
import kotlinx.android.synthetic.main.activity_slider3.*

class Slider3 : AppCompatActivity() {

    lateinit var list : ArrayList<Photo3>
    lateinit var adapter : AdapterSlider3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider3)

        init()
    }

    private fun init() {

        list = ArrayList<Photo3>()
        list.add(Photo3("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-01.jpg" , "Arash Altafi" , "1400/10/08","Slider 1"))
        list.add(Photo3("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-02.jpg" , "Reza Jafari" , "1400/10/08","Slider 1"))
        list.add(Photo3("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-03.jpg" , "Abbas Qoli" , "1400/10/08","Slider 1"))

        adapter = AdapterSlider3(list)
        rc_slider_3.adapter = adapter

        // Select Item
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rc_slider_3)

        // Effect
        val centerZoomLayoutManager = CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rc_slider_3.layoutManager = centerZoomLayoutManager

        rc_slider_3.isNestedScrollingEnabled = false

    }

}