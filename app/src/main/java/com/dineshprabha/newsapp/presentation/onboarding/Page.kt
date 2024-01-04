package com.dineshprabha.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.dineshprabha.newsapp.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "News App",
        description = "News app is very handy to know maore about latest news such as politics, sports, events etc..",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "News App",
        description = "News app is very handy to know maore about latest news such as politics, sports, events etc...",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "News App",
        description = "News app is very handy to know maore about latest news such as politics, sports, events etc..",
        image = R.drawable.onboarding3
    )
)
