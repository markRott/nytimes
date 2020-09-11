package com.example.newyorktimesapp.entities.mostpopular.dto


import com.example.newyorktimesapp.entities.mostpopular.ui.MediaMetadataUI
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

fun List<MediaMetadata>.toDomain(): List<MediaMetadataUI> {
    return this.map { it.toDomain() }
}

private fun MediaMetadata.toDomain(): MediaMetadataUI = MediaMetadataUI(
    url = url ?: "",
    format = format ?: "",
    height = height ?: 0,
    width = width ?: 0
)