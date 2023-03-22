package com.arash.altafi.menus.slider.slider5

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<VB : ViewBinding, RESPONSE : BaseResponseData>(val binding: VB?) :
    RecyclerView.ViewHolder(requireNotNull(binding?.root)) {

    lateinit var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>


    open fun bind(item: RESPONSE?) {
    }
}