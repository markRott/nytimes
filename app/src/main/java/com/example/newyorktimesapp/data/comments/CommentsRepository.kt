package com.example.newyorktimesapp.data.comments

import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI

interface CommentsRepository {

    suspend fun fetchComments(page:Int, url: String) : CommentResultUI
}