package com.dineshprabha.newsapp.domain.usecases.news

import com.dineshprabha.newsapp.data.local.NewsDao
import com.dineshprabha.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article)
    }
}