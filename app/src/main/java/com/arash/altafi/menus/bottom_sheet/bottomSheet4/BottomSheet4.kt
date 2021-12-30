package com.arash.altafi.menus.bottom_sheet.bottomSheet4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_bottom_sheet4.*

class BottomSheet4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet4)

        imageViewArrow.setOnClickListener {
            bottomSheetLayout.toggle()
        }
        bottomSheetLayout.setOnProgressListener { progress ->
            rotateArrow(progress)
        }
    }

    private fun rotateArrow(progress: Float) {
        imageViewArrow.rotation = -180 * progress
    }

}