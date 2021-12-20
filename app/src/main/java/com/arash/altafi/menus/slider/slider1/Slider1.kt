package com.arash.altafi.menus.slider.slider1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_bottom_navigation1.*

class Slider1 : AppCompatActivity() {

    private lateinit var list : ArrayList<Photo>
    private lateinit var adapterBanners : AdapterBanners
    val handler: Handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation1)

        list = ArrayList<Photo>()
        list.add(Photo("https://arashaltafi.ir/Social_Media/story-00.jpg"))
        list.add(Photo("https://arashaltafi.ir/Social_Media/story-01.jpg"))
        list.add(Photo("https://arashaltafi.ir/Social_Media/story-02.jpg"))

        adapterBanners = AdapterBanners(list)

        view_pager_bottom_1.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        view_pager_bottom_1.clipToPadding = false
        view_pager_bottom_1.clipChildren = false
        view_pager_bottom_1.offscreenPageLimit = 3
        view_pager_bottom_1.getChildAt(0)!!.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(20))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.1f
        }
        view_pager_bottom_1.setPageTransformer(transformer)
        view_pager_bottom_1.adapter = adapterBanners
        dots_indicator.setViewPager2(view_pager_bottom_1)
        view_pager_bottom_1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(sliderRunable)
                handler.postDelayed(sliderRunable, 5000)
            }
        })

    }

    private val sliderRunable = Runnable {
        if (this == null) return@Runnable
        val index: Int = view_pager_bottom_1.currentItem + 1
        view_pager_bottom_1.currentItem = index
        if (index > list.size - 1) {
            view_pager_bottom_1.currentItem = 0
        }
    }

}