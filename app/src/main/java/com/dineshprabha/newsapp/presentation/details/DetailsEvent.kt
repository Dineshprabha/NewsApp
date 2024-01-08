package com.dineshprabha.newsapp.presentation.details

import com.dineshprabha.newsapp.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}