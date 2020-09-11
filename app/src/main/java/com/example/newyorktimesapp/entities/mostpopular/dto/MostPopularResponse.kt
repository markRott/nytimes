package com.example.newyorktimesapp.entities.mostpopular.dto


import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI
import com.google.gson.annotations.SerializedName

class MostPopularResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: List<MostPopularArticle>?
)

fun MostPopularResponse.toDomain(): MostPopularUI = MostPopularUI(
    status = status ?: "",
    copyright = copyright ?: "",
    numResults = numResults ?: 0,
    results = results?.toDomain() ?: emptyList()
)