package com.dineshprabha.newsapp.data.remote

import com.dineshprabha.newsapp.BuildConfig
import com.dineshprabha.newsapp.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources: String,
        @Query("apikey") apikey : String = BuildConfig.API_KEY
    ):NewsResponse
    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery : String,
        @Query("page") page : Int,
        @Query("sources") sources: String,
        @Query("apiKey") apikey: String = BuildConfig.API_KEY
    ):NewsResponse
}