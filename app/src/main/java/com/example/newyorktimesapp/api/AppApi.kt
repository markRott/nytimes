package com.example.newyorktimesapp.api

import com.example.newyorktimesapp.data.base.BaseResponse
import com.example.newyorktimesapp.entities.comments.dto.CommentResultDto
import com.example.newyorktimesapp.entities.mostpopular.dto.ArticleDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {

    @GET("/svc/mostpopular/v2/{type}/{period}.json")
    suspend fun fetchMostEmailedArticles(
        @Path("type") type: String,
        @Path("period") period: Int
    ): Response<BaseResponse<List<ArticleDto>>>

//    @GET("/svc/community/v3/user-content/url.json")
//    suspend fun fetchComments(
//        @Query("offset") offset: Int,
//        @Query("url") url: String
//    ): CommentsResponse

    @GET("/svc/community/v3/user-content/url.json")
    suspend fun fetchComments(
        @Query("offset") offset: Int,
        @Query("url") url: String
    ): Response<BaseResponse<CommentResultDto>>
}