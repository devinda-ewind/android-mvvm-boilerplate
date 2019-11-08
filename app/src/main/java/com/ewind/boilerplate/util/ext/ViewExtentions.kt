package com.ewind.boilerplate.util.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.isVisibile(): Boolean = this.visibility == View.VISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

/*fun SwipeRefreshLayout.startRefreshing() {
  isRefreshing = true
}

fun SwipeRefreshLayout.stopRefreshing() {
  isRefreshing = false
}*/

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

