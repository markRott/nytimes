package com.example.newyorktimesapp.entities.mostpopular.dto

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.google.gson.annotations.SerializedName

class ArticleDto(
    @SerializedName("uri")
    val uri: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("id")
    val id: Long,
    @SerializedName("asset_id")
    val assetId: Long,
    @SerializedName("source")
    val source: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("abstract")
    val subTitle: String?,
    @SerializedName("media")
    val media: List<MediaDto>?
)

fun List<ArticleDto>.toDomain(): List<ArticleUI> {
    return this.map { it.toDomain() }
}

private fun ArticleDto.toDomain(): ArticleUI = ArticleUI(
    uri = uri ?: "",
    url = url ?: "",
    id = id,
    assetId = assetId,
    source = source ?: "",
    publishedDate = publishedDate ?: "",
    updated = updated ?: "",
    byline = byline ?: "",
    title = title ?: "",
    subTitle = subTitle ?: "",
    imageUrl = media?.firstOrNull()?.mediaMetadata?.lastOrNull()?.url ?: "",
    copyright = media?.firstOrNull()?.copyright ?: ""
)