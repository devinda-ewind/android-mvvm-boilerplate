package com.ewind.boilerplate.ui.component.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.ewind.boilerplate.util.PaginationScrollListener

object RecyclerViewBinding {

    @BindingAdapter("app:addVerticalItemDecoration")
    @JvmStatic
    fun RecyclerView.addVerticalItemDecoration(isVertical: Boolean) {
        addItemDecoration(DividerItemDecoration(context, if (isVertical) VERTICAL else HORIZONTAL))
    }

    @BindingAdapter("app:addOnScrollListener")
    @JvmStatic
    fun RecyclerView.addOnScrollListener(isRefresh: Boolean) {
        addOnScrollListener(object :
            PaginationScrollListener(this.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {

            }

            override fun isLastPage(): Boolean {
                return false
            }

            override fun isLoading(): Boolean {
                return isRefresh
            }
        })
    }
}