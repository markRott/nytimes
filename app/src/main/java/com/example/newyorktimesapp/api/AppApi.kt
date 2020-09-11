package com.example.newyorktimesapp.api

import com.example.newyorktimesapp.entities.mostpopular.dto.MostPopularResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {

    @GET("/svc/mostpopular/v2/{type}/{period}.json")
    suspend fun fetchMostEmailedArticles(
        @Path("type") type: String,
        @Path("period") period: Int
    ): MostPopularResponse
}