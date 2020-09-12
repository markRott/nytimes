package com.example.newyorktimesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI

@Database(entities = [MostPopularArticleUI::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteArticleDao
}