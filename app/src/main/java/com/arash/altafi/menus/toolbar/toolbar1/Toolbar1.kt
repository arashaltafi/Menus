package com.arash.altafi.menus.toolbar.toolbar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.activity_toolbar1.*

class Toolbar1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar1)

        setupToolbar()
    }

    private var toolbarView: CustomToolbar? = null
    private fun setupToolbar() {

        toolbarView = toolbar

        toolbarView?.apply {

            onBackClickToolbar = {
                finish()
            }

            setTitle("test title")

            onChangeSearch(0L, lifecycleScope) { text ->
                Toast.makeText(this@Toolbar1, "text = $text", Toast.LENGTH_SHORT).show()
            }

            setActionListener { tv, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        tv.hideKeyboard()
                    }
                }
                false
            }
            initToolbar(
                menu = listOf(
                    R.drawable.ic_delete_without_padding,
                    R.drawable.ic_add_without_padding
                ),
                onMenuItemClick = { drawableId ->
                    when (drawableId) {
                        R.drawable.ic_delete_without_padding -> {
                            Toast.makeText(this@Toolbar1, "click on delete", Toast.LENGTH_SHORT).show()
                        }
                        R.drawable.ic_add_without_padding -> {
                            Toast.makeText(this@Toolbar1, "click on add", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }
    }

}