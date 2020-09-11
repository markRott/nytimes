package com.example.newyorktimesapp.data

import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI

interface MostPopularRepository {

    suspend fun fetchMostPopularArticles(type: String, period: Int): MostPopularUI
}