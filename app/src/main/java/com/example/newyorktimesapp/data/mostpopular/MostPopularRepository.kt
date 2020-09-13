package com.example.newyorktimesapp.data.mostpopular

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

interface MostPopularRepository {

    suspend fun fetchArticles(type: String, period: Int): List<ArticleUI>

    suspend fun updateFavoriteState(favoriteState: Boolean, model: ArticleUI)

    suspend fun fetchFavoriteIds() :  HashSet<Long>
}