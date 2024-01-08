package com.dineshprabha.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.dineshprabha.newsapp.domain.model.Article
import com.dineshprabha.newsapp.domain.repositoy.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources : List<String>) : Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }
}