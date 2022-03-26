package com.arash.altafi.menus.bottom_sheet.bottomSheet5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.arash.altafi.menus.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet5.*
import kotlinx.android.synthetic.main.layout_persistent_bottomsheet.*

class BottomSheet5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet5)

        btnModalBottomsheet.setOnClickListener {
            MyBottomSheetDialogFragment().apply {
                show(supportFragmentManager, tag)
            }
        }

        val standardBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        standardBottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }
        })

        btnPersistentBottomsheet.setOnClickListener {
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

    }
}