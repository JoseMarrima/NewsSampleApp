package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.Result.Success

class LocalNewsDataSource(private val newsDao: NewsDao) {

    fun observeNews(): LiveData<Result<List<News>>> {
        return newsDao.observeNews().map {
            Success(it)
        }
    }

    suspend fun saveNews(newsList: List<News>) {
        newsDao.insertNews(newsList)
    }
}