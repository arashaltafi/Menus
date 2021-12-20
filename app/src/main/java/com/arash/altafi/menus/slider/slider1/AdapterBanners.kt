package com.arash.altafi.menus.slider.slider1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import com.bumptech.glide.Glide

class AdapterBanners(private val banners : ArrayList<Photo>) : RecyclerView.Adapter<BannersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banners , parent , false)
        return BannersViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        val itemBanners = banners[position]
        Glide.with(holder.itemView.context).load(itemBanners.image).into(holder.imgBanners)
    }

    override fun getItemCount(): Int = banners.size

}

class BannersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
{
    val imgBanners: ImageView = itemView.findViewById(R.id.img_banner)
}