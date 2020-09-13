package com.example.newyorktimesapp.entities.comments.dto


import com.example.newyorktimesapp.entities.comments.ui.CommentsData
import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI
import com.google.gson.annotations.SerializedName

class CommentsResponseDto(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("results")
    val results: CommentResultDto?
)

fun CommentsResponseDto.toDomain() : CommentsData = CommentsData(
    status = status ?: "",
    copyright = copyright ?: "",
    results = results?.toDomain() ?: CommentResultUI()
)