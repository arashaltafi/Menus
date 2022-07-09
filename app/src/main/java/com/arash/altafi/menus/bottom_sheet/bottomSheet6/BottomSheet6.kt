package com.arash.altafi.menus.bottom_sheet.bottomSheet6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import com.arash.altafi.menus.bottom_sheet.bottomSheet6.arcview.ArcLinearLayout
import kotlinx.android.synthetic.main.activity_bottom_sheet6.*
import kotlinx.android.synthetic.main.include_arc_button.*

class BottomSheet6 : AppCompatActivity() {

    private lateinit var strokeArc: ArcLinearLayout
    private lateinit var shadowArc: ArcLinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet6)

        init()
    }

    private fun init() {
        kick_me.setOnClickListener{
            if (include_buttons_scroll_view.isKnockedIn) {
                include_buttons_scroll_view.knockout()
            } else {
                include_buttons_scroll_view.knockIn()
            }
        }
        kick_swapped.setOnClickListener{
            include_arc_buttons_temp_arc.swapView(null)
        }
        include_buttons_stroke.setOnClickListener{
            include_arc_buttons_temp_arc.swapView(strokeArc)
        }
        include_buttons_shadow.setOnClickListener{
            include_arc_buttons_temp_arc.swapView(shadowArc)
        }
        strokeArc =
            layoutInflater.inflate(
                R.layout.stroke_arc_linear_layout,
                include_arc_buttons_temp_arc,
                false
            ) as ArcLinearLayout
        shadowArc =
            layoutInflater.inflate(
                R.layout.shadow_arc_linear_layout,
                include_arc_buttons_temp_arc,
                false
            ) as ArcLinearLayout
    }

}