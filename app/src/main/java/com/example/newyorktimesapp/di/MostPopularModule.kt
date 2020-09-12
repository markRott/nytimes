package com.example.newyorktimesapp.di

import com.example.newyorktimesapp.data.MostPopularRepository
import com.example.newyorktimesapp.data.MostPopularRepositoryImpl
import com.example.newyorktimesapp.ui.mostpopular.MostPopularVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mostPopularModule = module {
    single<MostPopularRepository> { MostPopularRepositoryImpl(api = get(), dao = get()) }
    viewModel { MostPopularVM(get()) }
}