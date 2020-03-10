package com.example.newsapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.source.NewsDataSource
import com.example.newsapp.data.source.asDomainModel
import com.example.newsapp.util.Constants

class RemoteNewsDataSource(private val service: NewsService) : NewsDataSource {

    private val observableNews = MutableLiveData<Result<List<News>>>()

    override fun observeNews(): LiveData<Result<List<News>>> {
        return observableNews
    }

    suspend fun refreshNews() {
        observableNews.value = getNews()
    }

    private suspend fun getNews(): Result<List<News>> {
        return Result.Success(service.getNewsTopHeadlines(
            Constants.COUNTRY, Constants.API_KEY
        ).asDomainModel())
    }

}