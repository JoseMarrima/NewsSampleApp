package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.newsapp.data.News
import com.example.newsapp.data.source.local.NewsDao
import com.example.newsapp.data.source.remote.NewsService
import com.example.newsapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DefaultNewsRepository @Inject constructor(private val service: NewsService,
                            val newsDao: NewsDao) : NewsRepository {

    private suspend fun getRemoteNews(): List<News> = withContext(Dispatchers.Default) {
        service.getNewsTopHeadlines(Constants.COUNTRY, Constants.API_KEY).asDomainModel()
    }

    private fun observeNewsDao(): LiveData<List<News>> {
        return newsDao.observeNews()
    }

    private suspend fun saveNews(newsList: List<News>) {
        newsDao.insertNews(newsList)
    }

    override fun observeNews(): LiveData<List<News>> = liveData {
        emitSource(observeNewsDao())
    }

    override suspend fun refreshNews() {
        val news = getRemoteNews()
        saveNews(news)
    }

}