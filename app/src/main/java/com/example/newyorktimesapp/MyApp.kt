package com.example.newyorktimesapp

import android.app.Application
import com.example.newyorktimesapp.di.commentsModule
import com.example.newyorktimesapp.di.databaseModule
import com.example.newyorktimesapp.di.mostPopularModule
import com.example.newyorktimesapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                networkModule,
                databaseModule,
                mostPopularModule,
                commentsModule
            )
        }
    }
}