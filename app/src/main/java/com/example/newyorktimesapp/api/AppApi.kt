package com.example.newyorktimesapp.api

import com.example.newyorktimesapp.entities.comments.dto.CommentsResponse
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

    // query 0 + 25 + (2*25) + (3*25) ...
    // https://api.nytimes.com/svc/community/v3/user-content/url.json?api-key=your-key&offset=0&url=https://www.nytimes.com/interactive/2019/04/30/dining/climate-change-food-eating-habits.html
    @GET("/svc/community/v3/user-content/url.json")
    suspend fun fetchComments(
        @Query("offset") offset: Int,
        @Query("url") url: String
    ): CommentsResponse
}