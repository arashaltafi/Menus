package com.arash.altafi.menus.slider.slider3

import android.content.DialogInterface
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import com.smarteist.autoimageslider.SliderViewAdapter

class AdapterSlider3(var list : ArrayList<Photo3>) : RecyclerView.Adapter<AdapterSlider3.ViewHolderSlider3>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider3 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider3 , parent , false)
        return ViewHolderSlider3(view)
    }

    override fun onBindViewHolder(holder: ViewHolderSlider3, position: Int) {
        val sliderItem: Photo3 = list[position]
        holder.textViewWriter.text = sliderItem.textViewWriter
        holder.textViewDate.text = sliderItem.textViewDate
        holder.textViewTitle.text = sliderItem.textViewTitle
        Glide.with(holder.itemView.context).load(sliderItem.imageSlider).into(holder.imageSlider)
        Glide.with(holder.itemView.context).load(sliderItem.imageViewWriter).into(holder.imageViewWriter)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context , "test : $position" , Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int  = list.size

    inner class ViewHolderSlider3(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageViewWriter : ImageView = itemView.findViewById(R.id.image_writer_slider_3)
        var imageSlider : ImageView = itemView.findViewById(R.id.image_slider_3)
        var textViewWriter : TextView = itemView.findViewById(R.id.txt_writer_slider_3)
        var textViewDate : TextView = itemView.findViewById(R.id.txt_date_slider_3)
        var textViewTitle : TextView = itemView.findViewById(R.id.txt_title_slider_3)

    }

}