package com.example.newyorktimesapp.ui.comments.adapter

import androidx.paging.DataSource
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import kotlinx.coroutines.CoroutineScope

class CommentsDataSourceFactory(
    private val articleUrl: String,
    private val repo: CommentsRepository,
    private val scope: CoroutineScope
) :
    DataSource.Factory<Int, CommentUI>() {

    override fun create(): DataSource<Int, CommentUI> {
        return CommentsDataSource(articleUrl, repo, scope)
    }
}