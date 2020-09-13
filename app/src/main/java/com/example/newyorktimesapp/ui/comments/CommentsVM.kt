package com.example.newyorktimesapp.ui.comments

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.ui.base.BaseVM
import com.example.newyorktimesapp.ui.comments.adapter.CommentsDataSourceFactory
import java.util.concurrent.Executors

class CommentsVM(private val dsFactory: CommentsDataSourceFactory) : BaseVM() {

    lateinit var commentsLD: LiveData<PagedList<CommentUI>>
        private set

    var articleUrl: String? = null
        set(value) {
            field = value
            initPageList(value ?: "")
        }

    private fun initPageList(articleUrl: String) {
        if (articleUrl.isEmpty()) return

        dsFactory.setupArticleUrl(articleUrl)
        val config = PagedList.Config.Builder()
            .setPageSize(25)
            .setEnablePlaceholders(false)
            .build()
        commentsLD = LivePagedListBuilder(dsFactory, config).build()
    }
}