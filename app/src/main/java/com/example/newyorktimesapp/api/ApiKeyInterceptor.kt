package com.example.newyorktimesapp.api

import com.example.newyorktimesapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val newUrl = req
            .url
            .newBuilder()
            .addQueryParameter("api-key", BuildConfig.API_KEY)
            .build()
        req = req.newBuilder().url(newUrl).build()
        return chain.proceed(req)
    }
}