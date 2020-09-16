package com.example.newyorktimesapp

import android.app.Application
import com.example.newyorktimesapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                firebaseAnalyticsModule,
                networkModule,
                databaseModule,
                resourceProviderModule,
                mostPopularModule,
                commentsModule,
                favoriteModule
            )
        }
    }
}