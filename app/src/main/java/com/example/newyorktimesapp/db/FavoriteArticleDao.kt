package com.example.newyorktimesapp.db

import androidx.room.*
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

@Dao
interface FavoriteArticleDao {

    @Query("SELECT * FROM favorite_articles")
    suspend fun fetchAllArticles() : List<ArticleUI>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticleToFavorite(model: ArticleUI)

    @Delete
    suspend fun removeFromFavorite(model: ArticleUI)
}