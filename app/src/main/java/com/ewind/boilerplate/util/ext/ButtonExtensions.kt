package com.ewind.boilerplate.util.ext

import android.widget.Button

/**
 * Button enabling/disabling modifiers
 */
fun Button.disableButton() {
    isEnabled = false
    alpha = 0.3f
}

fun Button.enableButton() {
    isEnabled = true
    alpha = 1.0f
}