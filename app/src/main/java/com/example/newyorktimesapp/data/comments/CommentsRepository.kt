package com.example.newyorktimesapp.data.comments

import com.example.newyorktimesapp.entities.comments.ui.CommentsResultUI

interface CommentsRepository {

    suspend fun fetchComments(page:Int, url: String) : CommentsResultUI
}