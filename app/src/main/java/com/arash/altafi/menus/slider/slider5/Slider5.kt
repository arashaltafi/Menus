package com.arash.altafi.menus.slider.slider5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_slider5.*

class Slider5 : AppCompatActivity() {

    var photo5: ArrayList<Photo5> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider5)

        init()
    }

    private fun init() {
        btnStart.setOnClickListener {
            slider5.startSliding()
            Toast.makeText(this, "start", Toast.LENGTH_SHORT).show()
        }

        btnStop.setOnClickListener {
            slider5.stopSliding()
            Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show()
        }

        slider5.apply {

            photo5.add(Photo5(1, R.drawable.test1, "test 1", ImageView.ScaleType.FIT_XY, "www.arashaltafi.ir"))
            photo5.add(Photo5(2, R.drawable.test2, "test 2", ImageView.ScaleType.FIT_XY, "www.arashaltafi.ir"))
            photo5.add(Photo5(3, R.drawable.test3, "test 3", ImageView.ScaleType.FIT_XY, "www.arashaltafi.ir"))
            photo5.add(Photo5(4, R.drawable.test4, "test 4", ImageView.ScaleType.FIT_XY, "www.arashaltafi.ir"))
            photo5.add(Photo5(5, R.drawable.test5, "test 5", ImageView.ScaleType.FIT_XY, "www.arashaltafi.ir"))

            slider5.setImageList(photo5, ImageView.ScaleType.FIT_XY)

            setItemClickListener(object : ItemClickListener {
                override fun onItemSelected(position: Int) {
                    Toast.makeText(this@Slider5, "position = $position", Toast.LENGTH_SHORT).show()
                }

            })
        }

    }

}