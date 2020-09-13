package com.example.newyorktimesapp.ui.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.ui.base.BaseVM
import com.example.newyorktimesapp.ui.comments.adapter.CommentsDataSourceFactory
import com.example.newyorktimesapp.utils.SimpleBoundaryCallback
import java.util.concurrent.Executors

class CommentsVM(private val repo: CommentsRepository) : BaseVM() {

    lateinit var commentsLD: LiveData<PagedList<CommentUI>>
        private set

    private var _emptyCommentsLD: MutableLiveData<Boolean> = MutableLiveData()
    val emptyCommentsLD: LiveData<Boolean> = _emptyCommentsLD

    var articleUrl: String? = null
        set(value) {
            field = value
            initPageList(value ?: "")
        }

    private fun initPageList(articleUrl: String) {
        if (articleUrl.isEmpty()) return

        changeLoadingState(true)
        val config = getPageListConfig()
        val dsFactory = CommentsDataSourceFactory(articleUrl, repo, viewModelScope)
        commentsLD = LivePagedListBuilder(dsFactory, config)
            .setBoundaryCallback(boundaryCallback())
            .build()
    }

    private fun boundaryCallback(): SimpleBoundaryCallback<CommentUI> {
        return object : SimpleBoundaryCallback<CommentUI>() {
            override fun onZeroItemsLoaded() {
                super.onZeroItemsLoaded()
                _emptyCommentsLD.value = false
                changeLoadingState(false)
            }
        }
    }

    private fun getPageListConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setPageSize(25)
            .setEnablePlaceholders(false)
            .build()
    }
}