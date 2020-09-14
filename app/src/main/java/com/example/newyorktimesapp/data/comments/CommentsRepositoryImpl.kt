package com.example.newyorktimesapp.data.comments

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.exception.AppException
import com.example.newyorktimesapp.api.Status
import com.example.newyorktimesapp.data.base.getResult
import com.example.newyorktimesapp.entities.comments.dto.toDomain
import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI

class CommentsRepositoryImpl(private val api: AppApi) :CommentsRepository {

    override suspend fun fetchComments(page: Int, url: String): CommentResultUI {
        val result = getResult { api.fetchComments(page, url) }
        if (result.status == Status.ERROR) throw AppException(result.msg ?: "Something went wrong")
        return result.data?.results?.toDomain() ?: CommentResultUI()
    }
}