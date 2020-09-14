package com.example.newyorktimesapp.entities.mostpopular.dto

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

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