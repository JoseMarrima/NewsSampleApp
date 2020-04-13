package com.example.newsapp.data.source

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.News
import kotlinx.coroutines.runBlocking
import java.util.LinkedHashMap

class FakeTestRepository : NewsRepository {

    var newsServiceData: LinkedHashMap<String, News> = LinkedHashMap()

    private val observableNews = MutableLiveData<List<News>>()

    @VisibleForTesting
    fun addNews(vararg news: News) {
        for (new in news) {
            newsServiceData[new.id] = new
        }
        runBlocking { refreshNews() }
    }

    override fun observeNews(): LiveData<List<News>> {
        runBlocking { refreshNews() }
        return observableNews
    }

    override suspend fun refreshNews() {
        observableNews.value = getNews()
    }

    private fun getNews(): List<News> {
        return newsServiceData.values.toList()
    }
}