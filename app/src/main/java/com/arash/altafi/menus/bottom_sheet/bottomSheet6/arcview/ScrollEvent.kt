package com.arash.altafi.menus.bottom_sheet.bottomSheet6.arcview

class ScrollEvent {
    var radius = 0
    var unregistred = false
        private set
    private var level = 0

    fun setUnregister(unregister: Boolean) {
        unregistred = unregister
    }

    fun setLevel(level: Int) {
        this.level = level
    }
}