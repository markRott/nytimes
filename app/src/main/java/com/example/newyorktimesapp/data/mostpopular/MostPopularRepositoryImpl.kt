package com.example.newyorktimesapp.data.mostpopular

import com.example.newyorktimesapp.api.AppApi
import com.example.newyorktimesapp.exception.AppException
import com.example.newyorktimesapp.data.base.BaseRepository
import com.example.newyorktimesapp.api.Status
import com.example.newyorktimesapp.db.FavoriteArticleDao
import com.example.newyorktimesapp.entities.mostpopular.dto.toDomain
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MostPopularRepositoryImpl(
    private val api: AppApi,
    private val dao: FavoriteArticleDao
) : BaseRepository(), MostPopularRepository {

    override suspend fun fetchArticles(type: String, period: Int): List<ArticleUI> {
        return withContext(Dispatchers.IO) {
            val result = getResult { api.fetchMostEmailedArticles(type, period) }
            if(result.status == Status.ERROR) throw AppException(result.msg ?: "Something went wrong")
            return@withContext result.data?.results?.toDomain() ?: emptyList()
        }
    }

    override suspend fun updateFavoriteState(favoriteState: Boolean, model: ArticleUI) {
        return withContext(Dispatchers.IO) {
            if (favoriteState) dao.addArticleToFavorite(model) else dao.removeFromFavorite(model)
        }
    }

    override suspend fun fetchFavoriteIds(): HashSet<Long> {
        return dao.fetchAllArticles().map { it.id }.toHashSet()
    }
}