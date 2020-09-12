package com.example.newyorktimesapp.data

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.db.FavoriteArticleDao
import com.example.newyorktimesapp.entities.mostpopular.dto.toDomain
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MostPopularRepositoryImpl(
    private val api: AppApi,
    private val dao: FavoriteArticleDao
) : MostPopularRepository {

    override suspend fun fetchMostPopularArticles(type: String, period: Int): MostPopularUI {
        return withContext(Dispatchers.IO) {
            api.fetchMostEmailedArticles(type, period).toDomain()
        }
    }

    override suspend fun updateFavoriteState(
        favoriteState: Boolean,
        model: MostPopularArticleUI
    ) {
        return withContext(Dispatchers.IO) {
            if (favoriteState) dao.addArticleToFavorite(model) else dao.removeFromFavorite(model)
        }
    }

    override suspend fun fetchFavoriteIds(): HashSet<Long> {
        return dao.fetchAllArticles().map { it.id }.toHashSet()
    }
}