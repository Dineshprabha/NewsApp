package com.dineshprabha.newsapp.domain.usecases.news

import com.dineshprabha.newsapp.data.local.NewsDao
import com.dineshprabha.newsapp.domain.model.Article
import com.dineshprabha.newsapp.domain.repositoy.NewsRepository

class DeleteArticle(
private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}