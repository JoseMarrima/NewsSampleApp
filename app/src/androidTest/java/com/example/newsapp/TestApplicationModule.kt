package com.example.newsapp

import com.example.newsapp.data.FakeTestRepository
import com.example.newsapp.data.source.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * A replacement for [ApplicationModule] to be used in tests. It simply creates a [FakeRepository].
 */
@Module
class TestApplicationModule {
    @Singleton
    @Provides
    fun provideRepository(): NewsRepository = FakeTestRepository()
}