package com.arash.altafi.menus.slider.slider5

import android.widget.ImageView

data class Photo5(
    val number: Int? = null,
    val videoUrl: String? = null,
    val audioUrl: String? = null,
    val imageUrl: Any, // url, resource uri, drawable
    val sliderUrl: String? = null,
    val hasUrlOrAction: Boolean? = null,
    val title: String = "",
    val scaleType: ImageView.ScaleType? = null,
): BaseResponseData()