package com.example.newsapp.data.source.remote

import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.source.asDomainModel
import com.example.newsapp.util.Constants.API_KEY
import com.example.newsapp.util.Constants.COUNTRY

class RemoteNewsDataSource(private val service: NewsService) {

    suspend fun getTest() : List<News> {
        return service.getNewsTopHeadlines(COUNTRY, API_KEY).asDomainModel()
    }

    suspend fun getRemoteNews(): Result<List<News>> {
        return Result.Success(service.getNewsTopHeadlines(
            COUNTRY, API_KEY
        ).asDomainModel())
    }

}