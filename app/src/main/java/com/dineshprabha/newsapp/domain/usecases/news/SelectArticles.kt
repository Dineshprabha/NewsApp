package com.dineshprabha.newsapp.domain.usecases.news

import com.dineshprabha.newsapp.data.local.NewsDao
import com.dineshprabha.newsapp.domain.model.Article
import com.dineshprabha.newsapp.domain.repositoy.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

    operator fun invoke() : Flow<List<Article>>{
        return newsRepository.selectArticles()
    }
}