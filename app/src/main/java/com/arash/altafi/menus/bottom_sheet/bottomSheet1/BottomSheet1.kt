package com.arash.altafi.menus.bottom_sheet.bottomSheet1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.arash.altafi.menus.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet1.*
import kotlinx.android.synthetic.main.play_list.*

class BottomSheet1 : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var isCheckBt: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet1)

        init()
    }

    private fun init() {

        bottomSheetBehavior = BottomSheetBehavior.from(cr_play_list)

        back_application.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        btn_bottom_sheet.setOnClickListener {
            if (isCheckBt) {
                // collapsed => close
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                isCheckBt = false
            } else {
                // expanded => open
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                isCheckBt = true
            }
        }

    }

}