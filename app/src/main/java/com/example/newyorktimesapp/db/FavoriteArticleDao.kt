package com.example.newyorktimesapp.db

import androidx.room.*
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI

@Dao
interface FavoriteArticleDao {

    @Query("SELECT * FROM favorite_articles")
    suspend fun fetchAllArticles() : List<MostPopularArticleUI>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticleToFavorite(model: MostPopularArticleUI)

    @Delete
    suspend fun removeFromFavorite(model: MostPopularArticleUI)
}