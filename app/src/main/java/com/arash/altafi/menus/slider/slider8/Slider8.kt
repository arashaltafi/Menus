package com.arash.altafi.menus.slider.slider8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_slider8.*

class Slider8 : AppCompatActivity() {

    lateinit var list : ArrayList<Photo8>
    lateinit var adapter : AdapterSlider8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider8)

        init()
    }

    private fun init() {

        list = ArrayList()
        list.add(Photo8("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-01.jpg" , "Arash Altafi" , "1400/10/08","Slider 1"))
        list.add(Photo8("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-02.jpg" , "Reza Jafari" , "1400/10/08","Slider 1"))
        list.add(Photo8("https://arashaltafi.ir/arash.jpg" , "https://arashaltafi.ir/Social_Media/story-03.jpg" , "Abbas Qoli" , "1400/10/08","Slider 1"))

        adapter = AdapterSlider8(list)
        rc_slider_8.adapter = adapter

        // Select Item
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rc_slider_8)

        // Effect
        val zoomRecyclerLayout = (this, LinearLayoutManager.HORIZONTAL, false)
        rc_slider_8.layoutManager = zoomRecyclerLayout

        rc_slider_8.isNestedScrollingEnabled = false

    }

}