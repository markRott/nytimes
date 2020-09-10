package com.example.newyorktimesapp.entities


import com.google.gson.annotations.SerializedName

class MediaMetadata(
    @SerializedName("url")
    val url: String?,
    @SerializedName("format")
    val format: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("width")
    val width: Int?
)