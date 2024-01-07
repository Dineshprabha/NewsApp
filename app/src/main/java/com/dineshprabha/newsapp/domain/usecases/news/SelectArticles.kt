package com.dineshprabha.newsapp.domain.usecases.news

import com.dineshprabha.newsapp.data.local.NewsDao
import com.dineshprabha.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke() : Flow<List<Article>>{
        return newsDao.getArticle()
    }
}