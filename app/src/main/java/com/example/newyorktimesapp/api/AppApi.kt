package com.example.newyorktimesapp.api

interface AppApi {

    suspend fun fetchMostViewedArticles()

    suspend fun fetchMostEmailedArticles()

    suspend fun fetchMostSharedArticles()
}