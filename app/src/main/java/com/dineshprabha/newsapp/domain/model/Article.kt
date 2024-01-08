package com.dineshprabha.newsapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dineshprabha.newsapp.domain.model.Source
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    val author: String? = null,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
):Parcelable