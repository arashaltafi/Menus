package com.arash.altafi.menus.bottom_sheet.bottomSheet7.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.menus.R
import com.arash.altafi.menus.bottom_sheet.bottomSheet7.dpPx
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        bottom_bar.isNestedScrollingEnabled = false

        val bottomSheet: View = findViewById(R.id.bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.peekHeight = 150.dpPx
    }
}