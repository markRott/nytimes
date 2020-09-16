package com.example.newyorktimesapp.data.favorite

import com.example.newyorktimesapp.KEY_ADD_TO_FAVORITE
import com.example.newyorktimesapp.analytics.AnalyticsContract
import com.example.newyorktimesapp.db.FavoriteArticleDao
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteRepositoryImpl(
    private val dao: FavoriteArticleDao,
    private val analytics: AnalyticsContract
) : FavoriteRepository {

    override suspend fun updateFavoriteState(favoriteState: Boolean, model: ArticleUI) {
        withContext(Dispatchers.IO) {
            if (favoriteState) dao.addArticleToFavorite(model) else dao.removeFromFavorite(model)
            if(favoriteState){
                analytics.logEvent(KEY_ADD_TO_FAVORITE, model.toString())
            }
        }
    }

    override suspend fun fetchFavoriteArticles(): List<ArticleUI> {
        return withContext(Dispatchers.IO) {
            dao.fetchAllArticles()
        }
    }

    override suspend fun fetchArticlesIds(): List<Long> {
        return withContext(Dispatchers.IO) {
            dao.fetchArticlesIds()
        }
    }
}