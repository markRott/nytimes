package com.example.newyorktimesapp.utils

import androidx.paging.PagedList

open class SimpleBoundaryCallback<T> : PagedList.BoundaryCallback<T>() {

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
    }

    override fun onItemAtFrontLoaded(itemAtFront: T) {
        super.onItemAtFrontLoaded(itemAtFront)
    }

    override fun onItemAtEndLoaded(itemAtEnd: T) {
        super.onItemAtEndLoaded(itemAtEnd)
    }
}