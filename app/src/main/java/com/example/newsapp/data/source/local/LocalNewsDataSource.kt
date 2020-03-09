package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.Result.Success
import com.example.newsapp.data.source.NewsDataSource

class LocalNewsDataSource(private val newsDao: NewsDao) : NewsDataSource {

    override fun observeNews(): LiveData<Result<List<News>>> {
        return newsDao.observeNews().map {
            Success(it)
        }
    }
}