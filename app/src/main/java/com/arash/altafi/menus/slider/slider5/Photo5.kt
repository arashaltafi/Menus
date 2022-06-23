package com.arash.altafi.menus.slider.slider5

import android.widget.ImageView

data class Photo5(
    val id: Long? = null,
    val imageUrl: Any? = null, // url, resource uri, drawable
    val title: String = "",
    val scaleType: ImageView.ScaleType? = null,
    val link: String? = null
)