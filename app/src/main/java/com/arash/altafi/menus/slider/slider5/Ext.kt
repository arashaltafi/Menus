package com.arash.altafi.menus.slider.slider5


import android.content.res.TypedArray

fun <T> List<T>?.letIfNotEmptyOrNull(let: (it: List<T>) -> Unit): List<T>? {
    this.takeIf { !it.isNullOrEmpty() }
        ?.let {
            let.invoke(it)
            return it
        }
    return null
}

fun List<Any>.isEqual(second: List<Any>): Boolean {
    if (this.size != second.size) {
        return false
    }

    return this.zip(second).all { (x, y) -> x == y }
}

inline fun <reified T : Enum<T>> TypedArray.getEnum(index: Int, default: T) =
    getInt(index, -1).let {
        if (it >= 0) enumValues<T>()[it] else default
    }