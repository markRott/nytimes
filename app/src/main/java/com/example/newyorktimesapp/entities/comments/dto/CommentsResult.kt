package com.example.newyorktimesapp.entities.comments.dto

import com.google.gson.annotations.SerializedName

class CommentResultDto(
    @SerializedName("comments")
    val comments: List<CommentDto>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("totalCommentsFound")
    val totalCommentsFound: Int?
)