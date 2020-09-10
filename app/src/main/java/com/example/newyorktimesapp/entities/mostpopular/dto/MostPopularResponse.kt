package com.example.newyorktimesapp.entities.mostpopular.dto


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