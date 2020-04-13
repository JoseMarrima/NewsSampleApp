package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.source.DefaultNewsRepository
import com.example.newsapp.data.source.NewsRepository
import com.example.newsapp.data.source.local.NewsDao
import com.example.newsapp.data.source.local.NewsDatabase
import com.example.newsapp.data.source.remote.NewsService
import com.example.newsapp.util.Constants.BASE_URL
import com.example.newsapp.util.Constants.DATABASE_NAME
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class])
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
}

@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultNewsRepository): NewsRepository
}