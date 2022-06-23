package com.arash.altafi.menus.slider.slider5

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import com.bumptech.glide.Glide

class ImageSliderVpAdapter(
    private var errorImage: Int,
    private var placeholder: Int,
    private var textAlign: Paint.Align,
    private var scaleType: ImageView.ScaleType? = null
): ListAdapter<Photo5, ImageSliderVpAdapter.ListAdapterViewHolder>(Companion) {

    private var touchListener: View.OnTouchListener? = null
    var onClickListener: ((Photo5) -> Unit)? = null

    inner class ListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImageSlider: ImageView = itemView.findViewById(R.id.ivImageSlider)
    }

    companion object : DiffUtil.ItemCallback<Photo5>() {
        override fun areItemsTheSame(oldItem: Photo5, newItem: Photo5): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Photo5, newItem: Photo5): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.component_item_image_slider, parent, false)
        return ListAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.apply {
                val context = holder.itemView.context
                val item = getItem(position)

                Glide
                    .with(context)
                    .load(item.imageUrl)
                    .placeholder(placeholder)
                    .error(errorImage)
                    .into(ivImageSlider)

                ivImageSlider.setOnClickListener { onClickListener?.invoke(item) }

                if (touchListener != null) {
                    ivImageSlider.setOnTouchListener { v, event ->
                        touchListener?.onTouch(v, event)
                        false
                    }
                }

            }
        }
    }

    fun setTouchListener(touchListener: View.OnTouchListener) {
        this.touchListener = touchListener
    }

}