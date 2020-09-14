package com.example.newyorktimesapp.entities.mostpopular.dto

import com.google.gson.annotations.SerializedName

class MediaDto(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataDto>?
)