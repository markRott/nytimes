package com.example.newyorktimesapp.ui.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.ui.comments.adapter.CommentsDSFactory
import com.example.newyorktimesapp.utils.PaginationStatus

class CommentsVM(private val repo: CommentsRepository) : ViewModel() {

    lateinit var commentsLD: LiveData<PagedList<CommentUI>>
        private set

    private val _paginationStatusLD = MutableLiveData<PaginationStatus>()
    val paginationStatusLD: LiveData<PaginationStatus> = _paginationStatusLD

    var articleUrl: String? = null
        set(value) {
            if (field == null) {
                field = value
                initPageList(value ?: "")
            }
        }

    private fun initPageList(articleUrl: String) {
        if (articleUrl.isEmpty()) return
        val config = getPageListConfig()
        val dsFactory = CommentsDSFactory(articleUrl, repo, viewModelScope, _paginationStatusLD)
        commentsLD = LivePagedListBuilder(dsFactory, config).build()
    }

    private fun getPageListConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setPageSize(25)
            .setEnablePlaceholders(false)
            .build()
    }
}