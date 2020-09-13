package com.example.newyorktimesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

@Database(entities = [ArticleUI::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteArticleDao
}