package com.codandotv.streamplayerapp.core_navigation.utils

import androidx.annotation.UiThread

@UiThread
fun MutableList<*>.pop() {
    if (this.isNotEmpty()) removeAt(lastIndex)
}
