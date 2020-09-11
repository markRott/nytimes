package com.example.newyorktimesapp.entities.mostpopular.dto

import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.google.gson.annotations.SerializedName

class MostPopularArticle(
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
    @SerializedName("section")
    val section: String?,
    @SerializedName("subsection")
    val subsection: String?,
    @SerializedName("nytdsection")
    val nytdsection: String?,
    @SerializedName("adx_keywords")
    val adxKeywords: String?,
    @SerializedName("column")
    val column: Any?,
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("abstract")
    val abstract: String?,
    @SerializedName("des_facet")
    val desFacet: List<String>?,
    @SerializedName("org_facet")
    val orgFacet: List<String>?,
    @SerializedName("per_facet")
    val perFacet: List<String>?,
    @SerializedName("geo_facet")
    val geoFacet: List<String>?,
    @SerializedName("media")
    val media: List<Media>?,
    @SerializedName("eta_id")
    val etaId: Int?
)

fun List<MostPopularArticle>.toDomain(): List<MostPopularArticleUI> {
    return this.map { it.toDomain() }
}

private fun MostPopularArticle.toDomain(): MostPopularArticleUI = MostPopularArticleUI(
    uri = uri ?: "",
    url = url ?: "",
    id = id,
    assetId = assetId,
    source = source ?: "",
    publishedDate = publishedDate ?: "",
    updated = updated ?: "",
    section = section ?: "",
    subsection = subsection ?: "",
    nytdsection = nytdsection ?: "",
    adxKeywords = adxKeywords ?: "",
    column = column ?: Any(),
    byline = byline ?: "",
    type = type ?: "",
    title = title ?: "",
    abstract = abstract ?: "",
    desFacet = desFacet ?: emptyList(),
    orgFacet = orgFacet ?: emptyList(),
    perFacet = perFacet ?: emptyList(),
    geoFacet = geoFacet ?: emptyList(),
    media = media?.toDomain() ?: emptyList(),
    etaId = etaId ?: 0
)