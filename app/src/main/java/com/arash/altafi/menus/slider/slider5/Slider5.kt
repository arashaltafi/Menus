package com.arash.altafi.menus.slider.slider5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_slider5.*

class Slider5 : AppCompatActivity() {

    private var photo5: ArrayList<Photo5> = arrayListOf()

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

            photo5.add(
                Photo5(
                    1,
                    "https://upmusics.com/wp-content/uploads/2021/01/143971813_1338518893210690_8280265321842515046_n.mp4",
                    "",
                    R.drawable.test1,
                    "",
                    true,
                    "title video",
                    ImageView.ScaleType.FIT_XY
                )
            )
            photo5.add(
                Photo5(
                    2,
                    "",
                    "https://irsv.upmusics.com/Downloads/Musics/Aron%20Afshar%20-%20Tabibe%20Maher%20(128).mp3",
                    "https://arashaltafi.ir/Social_Media/story-01.jpg",
                    "",
                    true,
                    "title music",
                    ImageView.ScaleType.FIT_XY
                )
            )
            photo5.add(
                Photo5(
                    3,
                    "",
                    "",
                    "https://arashaltafi.ir/Social_Media/story-02.jpg",
                    "https://arashaltafi.ir",
                    true,
                    "arash altafi",
                    ImageView.ScaleType.FIT_XY
                )
            )
            photo5.add(
                Photo5(
                    4,
                    "",
                    "",
                    R.drawable.test4,
                    "",
                    false,
                    "works",
                    ImageView.ScaleType.FIT_XY
                )
            )

            slider5.setImageList(photo5, ImageView.ScaleType.FIT_XY)

            setItemClickListener(object : ItemClickListener {
                override fun onItemSelected(item: Photo5) {
                    Toast.makeText(this@Slider5, "item = ${item.sliderUrl}", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

    }

    override fun onStop() {
        super.onStop()
        slider5.onPause()
    }

    override fun onPause() {
        super.onPause()
        slider5.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        slider5.onDestroy()
    }

}