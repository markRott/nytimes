package com.example.newyorktimesapp.data.comments

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.data.base.AppException
import com.example.newyorktimesapp.data.base.BaseRepository
import com.example.newyorktimesapp.data.base.Status
import com.example.newyorktimesapp.entities.comments.dto.toDomain
import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI
import com.example.newyorktimesapp.entities.mostpopular.dto.toDomain
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommentsRepositoryImpl(private val api: AppApi) : BaseRepository(), CommentsRepository {

    override suspend fun fetchComments(page: Int, url: String): CommentResultUI {
        val result = getResult { api.fetchComments(page, url) }
        if (result.status == Status.ERROR) throw AppException(result.msg ?: "Something went wrong")
        return result.data?.results?.toDomain() ?: CommentResultUI()
    }
}