package com.example.newyorktimesapp.entities.mostpopular.ui

data class MostPopularArticleUI(
    val uri: String,
    val url: String,
    val id: Long,
    val assetId: Long,
    val source: String,
    val publishedDate: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val adxKeywords: String,
    val column: Any,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val desFacet: List<String>,
    val orgFacet: List<String>,
    val perFacet: List<String>,
    val geoFacet: List<String>,
    val media: List<MediaUI>,
    val etaId: Int
)