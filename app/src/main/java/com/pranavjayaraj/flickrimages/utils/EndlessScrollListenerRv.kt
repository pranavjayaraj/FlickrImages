package com.pranavjayaraj.flickrimages.utils

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessScrollListenerRv : RecyclerView.OnScrollListener() {

    private var visibleThreshold = 2
    // The current offset index of data you have loaded
    private var currentPage = 0
    // The total number of items in the dataset after the last load
    private var previousTotalItemCount = 0
    // True if we are still waiting for the last set of data to load.
    private var loading = true
    // Sets the starting page index
    private val startingPageIndex = 0
    private var lastVisiblePos = -1
    // Added public ScrollState Storage variable --  setting default as IDLE.
    var scrollState = 0

    fun reset() {
        previousTotalItemCount = 0
        loading = true
    }

    fun retry()
    {
        loading = false
    }

    override fun onScrolled(view: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
        if (view.layoutManager == null || (dx ==0 && dy == 0)) return
        val totalItemCount = view.layoutManager!!.itemCount
        var spanSize = 1
        val lastVisibleItem = when(view.layoutManager){
            is GridLayoutManager -> {
                spanSize = ( view.layoutManager as GridLayoutManager).spanCount
                ( view.layoutManager as GridLayoutManager).findLastVisibleItemPosition()
            }
            else -> {
                TODO("Please add your layoutmanger in onScrolled.")
            }
        }
        if (totalItemCount < previousTotalItemCount) {
            this.previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }
        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }
        if (!loading && lastVisibleItem > totalItemCount-visibleThreshold*spanSize) {
            onLoadMore()
            loading = true
        }
    }

    override fun onScrollStateChanged(recyclerView: androidx.recyclerview.widget.RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        scrollState = newState
    }

    // Defines the process for actually loading more data based on page
    abstract fun onLoadMore()
}
