package com.example.newyorktimesapp.entities.comments.dto


import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.google.gson.annotations.SerializedName

class Comment(
    @SerializedName("commentID")
    val commentID: Int,
    @SerializedName("userID")
    val userID: Int,
    @SerializedName("userDisplayName")
    val userDisplayName: String?,
    @SerializedName("userLocation")
    val userLocation: String?,
    @SerializedName("userTitle")
    val userTitle: String?,
    @SerializedName("userURL")
    val userURL: String?,
    @SerializedName("picURL")
    val picURL: String?,
    @SerializedName("commentTitle")
    val commentTitle: String?,
    @SerializedName("commentBody")
    val commentBody: String?,
    @SerializedName("createDate")
    val createDate: String?
)

private fun Comment.toDomain(): CommentUI = CommentUI(
    commentID = commentID,
    userID = userID,
    userDisplayName = userDisplayName ?: "",
    userLocation = userLocation ?: "",
    userTitle = userTitle ?: "",
    userURL = userURL ?: "",
    picURL = picURL ?: "",
    commentTitle = commentTitle ?: "",
    commentBody = commentBody ?: "",
    createDate = createDate ?: ""
)

fun List<Comment>.toDomain() : List<CommentUI> = this.map { it.toDomain() }