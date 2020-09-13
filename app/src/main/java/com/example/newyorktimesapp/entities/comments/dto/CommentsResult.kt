package com.example.newyorktimesapp.entities.comments.dto


import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI
import com.google.gson.annotations.SerializedName

class CommentResultDto(
    @SerializedName("comments")
    val comments: List<CommentDto>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("totalCommentsFound")
    val totalCommentsFound: Int?
)

fun CommentResultDto.toDomain() : CommentResultUI = CommentResultUI(
    comments = comments?.toDomain() ?: emptyList(),
    page = page ?: 0,
    totalCommentsFound = totalCommentsFound ?: 0
)