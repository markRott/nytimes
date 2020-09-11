package com.example.newyorktimesapp.data

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.entities.mostpopular.dto.toDomain
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MostPopularRepositoryImpl(private val api: AppApi) : MostPopularRepository {

    override suspend fun fetchMostPopularArticles(type: String, period: Int): MostPopularUI {
        return withContext(Dispatchers.IO) {
            api.fetchMostEmailedArticles(type, period).toDomain()
        }
    }
}