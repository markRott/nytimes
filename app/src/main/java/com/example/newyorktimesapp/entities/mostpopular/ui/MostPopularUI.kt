package com.example.newyorktimesapp.entities.mostpopular.ui

data class MostPopularUI(
    val status: String,
    val copyright: String,
    val numResults: Int,
    val results: List<MostPopularArticleUI>
)