package com.example.newyorktimesapp.data

interface MostPopularRepository {

    fun fetchMostViewedArticles()

    fun fetchMostEmailedArticles()

    fun fetchMostSharedArticles()
}