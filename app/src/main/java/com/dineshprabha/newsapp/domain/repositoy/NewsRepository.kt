package com.dineshprabha.newsapp.domain.repositoy

import androidx.paging.PagingData
import com.dineshprabha.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources : List<String>) : Flow<PagingData<Article>>
}