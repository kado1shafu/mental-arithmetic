package com.constantine.silver.mentalarithmetic

import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}

inline fun View.snack(@StringRes messageResId: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, messageResId, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes textResId: Int, @ColorInt color: Int? = null, listener: (View) -> Unit) {
    setAction(textResId, listener)
    color?.let { setActionTextColor(color) }
}