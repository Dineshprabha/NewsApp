package com.dineshprabha.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.dineshprabha.newsapp.domain.model.Article
import com.dineshprabha.newsapp.domain.repositoy.NewsRepository
import com.dineshprabha.newsapp.presentation.search.SearchEvent
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String ,sources : List<String>) : Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery , sources = sources)
    }
}