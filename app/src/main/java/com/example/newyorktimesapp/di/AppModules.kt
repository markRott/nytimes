package com.example.newyorktimesapp.di

import com.example.newyorktimesapp.data.comments.CommentsRepository
import com.example.newyorktimesapp.data.comments.CommentsRepositoryImpl
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepository
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepositoryImpl
import com.example.newyorktimesapp.ui.comments.CommentsVM
import com.example.newyorktimesapp.ui.mostpopular.MostPopularVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mostPopularModule = module {
    single<MostPopularRepository> { MostPopularRepositoryImpl(api = get(), dao = get()) }
    viewModel { MostPopularVM(repo = get()) }
}

val commentsModule = module {
    single<CommentsRepository> { CommentsRepositoryImpl(api = get()) }
    viewModel { CommentsVM(get()) }
}