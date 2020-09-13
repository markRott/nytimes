package com.example.newyorktimesapp.ui.comments.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.utils.PaginationStatus
import kotlinx.coroutines.CoroutineScope

class CommentsDataSourceFactory(
    private val articleUrl: String,
    private val repo: CommentsRepository,
    private val scope: CoroutineScope,
    private val paginationStatusLD: MutableLiveData<PaginationStatus>
) :
    DataSource.Factory<Int, CommentUI>() {

    override fun create(): DataSource<Int, CommentUI> {
        return CommentsDataSource(articleUrl, repo, scope, paginationStatusLD)
    }
}