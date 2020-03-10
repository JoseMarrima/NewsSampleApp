package com.example.newsapp.data.source.remote

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.source.NewsDataSource

class RemoteNewsDataSource(private val service: NewsService) : NewsDataSource {
    override fun observeNews(): LiveData<Result<List<News>>> {
        return service.getNewsTopHeadlines("us",
            "83dbe5057f1e4920a636cdfe06502b36").articles
    }

}