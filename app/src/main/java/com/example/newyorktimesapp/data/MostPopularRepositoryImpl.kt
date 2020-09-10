package com.example.newyorktimesapp.data

import com.example.newyorktimesapp.api.AppApi

class MostPopularRepositoryImpl(private val api: AppApi) : MostPopularRepository {

    override fun fetchMostViewedArticles() {
    }

    override fun fetchMostEmailedArticles() {
    }

    override fun fetchMostSharedArticles() {
    }
}