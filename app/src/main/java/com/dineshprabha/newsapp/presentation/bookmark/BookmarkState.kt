package com.dineshprabha.newsapp.presentation.bookmark

import com.dineshprabha.newsapp.domain.model.Article
import com.dineshprabha.newsapp.domain.usecases.news.SelectArticles

data class BookmarkState(
    val articles: List<Article> = emptyList()
) {
}