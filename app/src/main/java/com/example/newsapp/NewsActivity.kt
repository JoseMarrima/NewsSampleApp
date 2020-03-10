package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.data.source.remote.NewsService
import com.example.newsapp.data.source.remote.RemoteNewsDataSource
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsService by lazy {
            Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(NewsService::class.java)
        }

        val test = RemoteNewsDataSource(newsService)

        runBlocking { test.refreshNews() }

        Timber.d("${test.observeNews().value}")
    }
}
