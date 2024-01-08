package com.dineshprabha.newsapp.di

import android.app.Application
import androidx.room.Room
import com.dineshprabha.newsapp.data.local.NewsDao
import com.dineshprabha.newsapp.data.local.NewsDatabase
import com.dineshprabha.newsapp.data.local.NewsTypeConverter
import com.dineshprabha.newsapp.data.manager.LocalUserManagerImpl
import com.dineshprabha.newsapp.data.remote.NewsApi
import com.dineshprabha.newsapp.data.repository.NewsRepositoryImpl
import com.dineshprabha.newsapp.domain.manager.LocalUserManager
import com.dineshprabha.newsapp.domain.repositoy.NewsRepository
import com.dineshprabha.newsapp.domain.usecases.AppEntryUseCases
import com.dineshprabha.newsapp.domain.usecases.ReadAppEntry
import com.dineshprabha.newsapp.domain.usecases.SaveAppEntry
import com.dineshprabha.newsapp.domain.usecases.news.DeleteArticle
import com.dineshprabha.newsapp.domain.usecases.news.GetNews
import com.dineshprabha.newsapp.domain.usecases.news.NewsUseCases
import com.dineshprabha.newsapp.domain.usecases.news.SearchNews
import com.dineshprabha.newsapp.domain.usecases.news.SelectArticle
import com.dineshprabha.newsapp.domain.usecases.news.SelectArticles
import com.dineshprabha.newsapp.domain.usecases.news.UpsertArticle
import com.dineshprabha.newsapp.utils.Constants.BASE_URL
import com.dineshprabha.newsapp.utils.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManagement(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)

    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)

        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}