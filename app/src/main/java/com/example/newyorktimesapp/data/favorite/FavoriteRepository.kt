package com.example.newyorktimesapp.data.favorite

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

interface FavoriteRepository {

    suspend fun updateFavoriteState(favoriteState: Boolean, model: ArticleUI)

    suspend fun fetchFavoriteArticles(): List<ArticleUI>

    suspend fun fetchArticlesIds() : List<Long>
}