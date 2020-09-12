package com.example.newyorktimesapp.di

import android.content.Context
import androidx.room.Room
import com.example.newyorktimesapp.db.AppDatabase
import com.example.newyorktimesapp.db.FavoriteArticleDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(context = androidApplication()) }
    single { provideFavoriteDao(appDataBase = get()) }
}

private fun provideDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "nyt_database").build()
}

private fun provideFavoriteDao(appDataBase: AppDatabase): FavoriteArticleDao {
    return appDataBase.favoriteDao()
}