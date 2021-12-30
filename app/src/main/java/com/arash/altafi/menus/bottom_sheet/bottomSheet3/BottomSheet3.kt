package com.arash.altafi.menus.bottom_sheet.bottomSheet3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.arash.altafi.menus.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet3.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheet3 : AppCompatActivity() {

    private lateinit var bottomSheet : BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet3)

        init()
    }

    private fun init() {

        bottomSheet = BottomSheetBehavior.from(bottom_sheet)

        btn_expand.setOnClickListener(View.OnClickListener {
            if (bottomSheet.state === BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else if (bottomSheet.state === BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        })

        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    btn_expand.text = "Collapse"
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    btn_expand.text = "Expand"
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //Todo
            }
        })

    }

}