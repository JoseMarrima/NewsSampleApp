package com.example.newsapp.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.source.asDomainModel
import com.example.newsapp.util.Constants

class RemoteNewsDataSource(private val service: NewsService) {

    suspend fun getRemoteNews(): Result<List<News>> {
        return Result.Success(service.getNewsTopHeadlines(
            Constants.COUNTRY, Constants.API_KEY
        ).asDomainModel())
    }

}