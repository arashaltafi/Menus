package com.arash.altafi.menus.toolbar.toolbar1

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewAnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.hypot
import kotlin.math.roundToInt

fun Int.toPx(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return (this * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun Int.toDp(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return (this / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun Float.toPx(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
}

fun View.toShow() {
    this.visibility = View.VISIBLE
}

fun TextView.clear() {
    this.text = ""
}

fun EditText.textString() =
    this.text.toString()

fun View.isShow(): Boolean {
    return this.visibility == View.VISIBLE
}

fun View.toHide() {
    this.visibility = View.INVISIBLE
}

fun View.isHide(): Boolean {
    return this.visibility == View.INVISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

fun EditText.onChange(
    waitMs: Long = 800L,
    scope: CoroutineScope,
    destinationFunction: (String) -> Unit,
): TextWatcher = afterTextChange(debounce(waitMs, scope, destinationFunction))

fun EditText?.afterTextChange(afterTextChanged: (String) -> Unit): TextWatcher {
    var beforeText = ""
    val watcher = object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            if (beforeText == editable.toString())
                return

            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            beforeText = s.toString()
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    }

    this?.addTextChangedListener(watcher)

    return watcher
}

fun <T> debounce(
    waitMs: Long = 300L,
    scope: CoroutineScope,
    destinationFunction: (T) -> Unit
): (T) -> Unit {
    var debounceJob: Job? = null
    return { param: T ->
        debounceJob?.cancel()
        debounceJob = scope.launch {
            delay(waitMs)
            destinationFunction(param)
        }
    }
}

fun View.showKeyboard() {
    this.requestFocus()
    try {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    } catch (e: java.lang.Exception) {
    }
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

inline fun <reified NEW> Any.isCastable(): Boolean {
    return this is NEW
}

inline fun <reified NEW> Any.cast(): NEW? {
    return if (this.isCastable<NEW>())
        this as NEW
    else null
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

enum class RevealModel {
    START,
    CENTER,
    END
}

fun View.reveal(
    duration: Long, model: RevealModel,
    endListener: (() -> Unit)? = null
) {
    val cxF = when (model) {
        RevealModel.START -> width
        RevealModel.CENTER -> width / 2
        else -> 0
    }

    val cyF = height / 2

    val radius = hypot(width.toDouble(), height.toDouble()).toFloat()

    ViewAnimationUtils.createCircularReveal(
        this, cxF, cyF, 0f, radius
    ).apply {
        setDuration(duration)
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                toShow()
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                enable()
                endListener?.invoke()
            }
        })
    }.start()
}

fun View.unReveal(
    duration: Long, model: RevealModel,
    endListener: (() -> Unit)? = null
) {

    val cxF = when (model) {
        RevealModel.START -> right
        RevealModel.CENTER -> width / 2
        else -> left
    }

    val cyF = height / 2

    val radius = hypot(width.toDouble(), height.toDouble()).toFloat()

    ViewAnimationUtils.createCircularReveal(
        this, cxF, cyF, radius, 0f
    ).apply {
        setDuration(duration)
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                disable()
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                toHide()
                endListener?.invoke()
            }
        })
    }.start()
}