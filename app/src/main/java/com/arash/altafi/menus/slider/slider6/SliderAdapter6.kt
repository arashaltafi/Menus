package com.arash.altafi.menus.slider.slider6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.arash.altafi.menus.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_slider_6.view.*

class SliderAdapter6(private val model: ArrayList<Photo6>): PagerAdapter() {

    override fun getCount(): Int = model.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) = container.removeView(`object` as View)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_slider_6, container, false)
        container.addView(view)

        val model = model[position]

        Glide
            .with(view.context)
            .load(model.imageUrl)
            .into(view.ivImage)

        return view
    }

    override fun getPageWidth(position: Int): Float = 0.95F

}