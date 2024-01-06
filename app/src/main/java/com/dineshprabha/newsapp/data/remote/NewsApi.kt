package com.dineshprabha.newsapp.data.remote

import com.dineshprabha.newsapp.data.remote.dto.NewsResponse
import com.dineshprabha.newsapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources: String,
        @Query("apikey") apikey : String =API_KEY
    ):NewsResponse
}