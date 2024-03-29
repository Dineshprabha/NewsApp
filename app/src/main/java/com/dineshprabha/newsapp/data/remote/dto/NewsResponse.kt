package com.dineshprabha.newsapp.data.remote.dto

import com.dineshprabha.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)