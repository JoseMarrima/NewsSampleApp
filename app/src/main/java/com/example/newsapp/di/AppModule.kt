package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.source.DefaultNewsRepository
import com.example.newsapp.data.source.local.LocalNewsDataSource
import com.example.newsapp.data.source.local.NewsDao
import com.example.newsapp.data.source.local.NewsDatabase
import com.example.newsapp.data.source.remote.NewsService
import com.example.newsapp.data.source.remote.RemoteNewsDataSource
import com.example.newsapp.util.Constants.BASE_URL
import com.example.newsapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsDao(newsDatabase: NewsDatabase) : NewsDao {
        return newsDatabase.newsDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsDatabase(context: Context) : NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, DATABASE_NAME).build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsService() : NewsService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NewsService::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsRepository(remoteNewsDataSource: RemoteNewsDataSource,
                              localNewsDataSource: LocalNewsDataSource) : DefaultNewsRepository {
        return DefaultNewsRepository(remoteNewsDataSource, localNewsDataSource)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideLocalDataSource(newsDao: NewsDao) : LocalNewsDataSource {
        return LocalNewsDataSource(newsDao)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRemoteDataSource(service: NewsService) : RemoteNewsDataSource {
        return RemoteNewsDataSource(service)
    }
}