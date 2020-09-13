package com.example.newyorktimesapp.ui.comments.adapter

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.entities.comments.ui.CommentsResultUI
import kotlinx.coroutines.*

class CommentsDataSource(
    private val articleUrl: String,
    private val repo: CommentsRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, CommentUI>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CommentUI>
    ) {
        fetchData(0) {
            callback.onResult(it.comments, 0, it.page)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CommentUI>) = Unit

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CommentUI>) {
        fetchData(params.key) {
            callback.onResult(it.comments, it.page)
        }
    }

    private fun fetchData(page: Int, action: (CommentsResultUI) -> Unit) {
        scope.launch(Dispatchers.IO) {
            val resp = repo.fetchComments(page, articleUrl)
            val nextPage = resp.page + 24
            action(resp.copy(page = nextPage))
        }
    }
}