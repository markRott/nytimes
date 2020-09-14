package com.example.newyorktimesapp.entities.comments.dto

import com.google.gson.annotations.SerializedName

class CommentDto(
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