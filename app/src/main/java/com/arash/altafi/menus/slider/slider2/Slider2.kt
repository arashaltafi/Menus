package com.arash.altafi.menus.slider.slider2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import com.arash.altafi.menus.slider.slider1.Photo
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_slider2.*

class Slider2 : AppCompatActivity() {

    private lateinit var list : ArrayList<Photo2>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider2)

        list = ArrayList<Photo2>()
        list.add(Photo2("arash" , "https://arashaltafi.ir/Social_Media/story-00.jpg"))
        list.add(Photo2("reza" , "https://arashaltafi.ir/Social_Media/story-01.jpg"))
        list.add(Photo2("ali" , "https://arashaltafi.ir/Social_Media/story-02.jpg"))
        list.add(Photo2("jafar" , "https://arashaltafi.ir/Social_Media/story-03.jpg"))


        imageSlider2.setSliderAdapter(AdapterSlider2(list))

        imageSlider2.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider2.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider2.indicatorSelectedColor = Color.WHITE
        imageSlider2.indicatorUnselectedColor = Color.GRAY
        imageSlider2.scrollTimeInSec = 4 //set scroll delay in seconds  :
        imageSlider2.startAutoCycle()

    }
}