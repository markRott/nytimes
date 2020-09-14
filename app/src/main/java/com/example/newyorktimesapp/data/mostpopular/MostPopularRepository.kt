package com.example.newyorktimesapp.data.mostpopular

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

interface MostPopularRepository {

    suspend fun fetchArticles(type: String, period: Int): List<ArticleUI>
}