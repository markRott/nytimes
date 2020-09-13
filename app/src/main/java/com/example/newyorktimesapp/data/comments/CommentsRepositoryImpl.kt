package com.example.newyorktimesapp.data.comments

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.entities.comments.dto.toDomain
import com.example.newyorktimesapp.entities.comments.ui.CommentsResultUI
import kotlinx.coroutines.withContext

class CommentsRepositoryImpl(private val api: AppApi) : CommentsRepository {

    override suspend fun fetchComments(page: Int, url: String): CommentsResultUI {
        return api.fetchComments(page, url).toDomain().results
    }
}