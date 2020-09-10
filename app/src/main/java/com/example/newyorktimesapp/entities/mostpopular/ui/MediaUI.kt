package com.example.newyorktimesapp.entities.mostpopular.ui

data class MediaUI(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approvedForSyndication: Int,
    val mediaMetadata: List<MediaMetadataUI>
)