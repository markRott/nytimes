package com.example.newyorktimesapp.di

import com.example.newyorktimesapp.BuildConfig
import com.example.newyorktimesapp.api.ApiKeyInterceptor
import com.example.newyorktimesapp.api.AppApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { ApiKeyInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideAppApi(get()) }
}

private fun provideOkHttpClient(authInterceptor: ApiKeyInterceptor): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = (HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(logging)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit
        .Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideAppApi(retrofit: Retrofit): AppApi = retrofit.create(AppApi::class.java)