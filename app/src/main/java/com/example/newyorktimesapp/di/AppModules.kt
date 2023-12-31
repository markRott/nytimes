package com.example.newyorktimesapp.di

import com.example.newyorktimesapp.analytics.AnalyticsContract
import com.example.newyorktimesapp.analytics.FirebaseAnalyticsImpl
import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.data.comments.CommentsRepositoryImpl
import com.example.newyorktimesapp.data.favorite.FavoriteRepository
import com.example.newyorktimesapp.data.favorite.FavoriteRepositoryImpl
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepository
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepositoryImpl
import com.example.newyorktimesapp.ui.comments.CommentsVM
import com.example.newyorktimesapp.ui.favorites.FavoritesVM
import com.example.newyorktimesapp.ui.mostpopular.MostPopularVM
import com.example.newyorktimesapp.utils.ResourceProviderImpl
import com.example.newyorktimesapp.utils.ResourcesProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val firebaseAnalyticsModule = module {
    single { Firebase.analytics }
    single<AnalyticsContract> { FirebaseAnalyticsImpl(analytics = get()) }
}

val resourceProviderModule = module {
    single<ResourcesProvider> { ResourceProviderImpl(androidApplication()) }
}

val mostPopularModule = module {
    single<MostPopularRepository> { MostPopularRepositoryImpl(api = get()) }
    single<FavoriteRepository> { FavoriteRepositoryImpl(dao = get(), analytics = get()) }
    viewModel { MostPopularVM(articleRepo = get(), favoriteRepo = get(), resourceProvider = get()) }
}

val commentsModule = module {
    single<CommentsRepository> { CommentsRepositoryImpl(api = get()) }
    viewModel { CommentsVM(get()) }
}

val favoriteModule = module {
    viewModel { FavoritesVM(get()) }
}