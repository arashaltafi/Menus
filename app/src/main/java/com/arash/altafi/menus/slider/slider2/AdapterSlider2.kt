package com.arash.altafi.menus.slider.slider2

import android.content.DialogInterface
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.arash.altafi.menus.R
import com.smarteist.autoimageslider.SliderViewAdapter

class AdapterSlider2(var list : ArrayList<Photo2>) : SliderViewAdapter<AdapterSlider2.SliderAdapterVH>() {

    fun renewItems(list2 : ArrayList<Photo2>) {
        list = list2
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: Photo2) {
        list.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider2 , parent , false)
        return SliderAdapterVH(view)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: Photo2 = list[position]
        viewHolder.textView.text = sliderItem.name
        Glide.with(viewHolder.itemView.context).load(sliderItem.image).into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(viewHolder.itemView.context, "This is item in position $position", Toast.LENGTH_SHORT).show()
            }
            override fun onClick(dialog: DialogInterface?, which: Int) {

            }
        })
    }

    override fun getCount(): Int = list.size

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {

        var imageView : ImageView = itemView.findViewById(R.id.iv_auto_image_slider)
        var textView : TextView = itemView.findViewById(R.id.tv_auto_image_slider)

    }

}