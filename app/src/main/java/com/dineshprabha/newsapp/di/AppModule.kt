package com.dineshprabha.newsapp.di

import android.app.Application
import com.dineshprabha.newsapp.data.manager.LocalUserManagerImpl
import com.dineshprabha.newsapp.domain.manager.LocalUserManager
import com.dineshprabha.newsapp.domain.usecases.AppEntryUseCases
import com.dineshprabha.newsapp.domain.usecases.ReadAppEntry
import com.dineshprabha.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}