package com.example.newyorktimesapp.entities.comments.dto


import com.example.newyorktimesapp.entities.comments.ui.CommentsData
import com.example.newyorktimesapp.entities.comments.ui.CommentsResultUI
import com.google.gson.annotations.SerializedName

class CommentsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("results")
    val results: CommentResult?
)

fun CommentsResponse.toDomain() : CommentsData = CommentsData(
    status = status ?: "",
    copyright = copyright ?: "",
    results = results?.toDomain() ?: CommentsResultUI()
)