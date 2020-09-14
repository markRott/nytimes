package com.example.newyorktimesapp.ui.comments.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI
import com.example.newyorktimesapp.utils.PaginationStatus
import kotlinx.coroutines.*

class CommentsDataSource(
    private val articleUrl: String,
    private val repo: CommentsRepository,
    private val scope: CoroutineScope,
    private val paginationStatusLD: MutableLiveData<PaginationStatus>
) : PageKeyedDataSource<Int, CommentUI>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CommentUI>) {
        paginationStatusLD.postValue(PaginationStatus.Loading)
        fetchData(0) {
            callback.onResult(it.comments, 0, it.page)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CommentUI>) {
        fetchData(params.key) {
            callback.onResult(it.comments, it.page)
        }
    }

    private fun fetchData(page: Int, action: (CommentResultUI) -> Unit) {
        scope.launch(Dispatchers.IO) {

            val resp = repo.fetchComments(page, articleUrl)
            if (resp.comments.isNotEmpty()) {
                val nextPage = resp.page + 24
                action(resp.copy(page = nextPage))
                paginationStatusLD.postValue(PaginationStatus.NotEmpty)
            } else paginationStatusLD.postValue(PaginationStatus.Empty)

        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CommentUI>) = Unit
}