package com.example.newyorktimesapp.entities.mostpopular.dto

import com.example.newyorktimesapp.entities.mostpopular.ui.MediaUI
import com.google.gson.annotations.SerializedName

class Media(
    @SerializedName("type")
    val type: String?,
    @SerializedName("subtype")
    val subtype: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int?,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadata>?
)

fun List<Media>.toDomain(): List<MediaUI> {
    return this.map { it.toDomain() }
}

private fun Media.toDomain(): MediaUI = MediaUI(
    type = type ?: "",
    subtype = subtype ?: "",
    caption = caption ?: "",
    copyright = copyright ?: "",
    approvedForSyndication = approvedForSyndication ?: 0,
    mediaMetadata = mediaMetadata?.toDomain() ?: emptyList()
)