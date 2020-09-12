package com.example.newyorktimesapp.entities.comments.dto


import com.example.newyorktimesapp.entities.comments.ui.CommentsResultUI
import com.google.gson.annotations.SerializedName

class CommentResult(
    @SerializedName("comments")
    val comments: List<Comment>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("totalCommentsFound")
    val totalCommentsFound: Int?
)

fun CommentResult.toDomain() : CommentsResultUI = CommentsResultUI(
    comments = comments?.toDomain() ?: emptyList(),
    page = page ?: 0,
    totalCommentsFound = totalCommentsFound ?: 0
)