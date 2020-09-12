package com.example.newyorktimesapp.data.mostpopular

import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI

interface MostPopularRepository {

    suspend fun fetchMostPopularArticles(type: String, period: Int): MostPopularUI

    suspend fun updateFavoriteState(favoriteState: Boolean, model: MostPopularArticleUI)

    suspend fun fetchFavoriteIds() :  HashSet<Long>
}