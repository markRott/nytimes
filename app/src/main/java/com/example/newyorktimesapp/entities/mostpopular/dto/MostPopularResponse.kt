package com.example.newyorktimesapp.entities.mostpopular.dto


import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI
import com.google.gson.annotations.SerializedName

class MostPopularResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("results")
    val results: List<ArticleDto>?
)

fun MostPopularResponse.toDomain(): MostPopularUI = MostPopularUI(
    status = status ?: "",
    copyright = copyright ?: "",
    results = results?.toDomain() ?: emptyList()
)