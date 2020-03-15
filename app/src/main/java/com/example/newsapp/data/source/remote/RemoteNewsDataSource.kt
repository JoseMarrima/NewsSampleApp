package com.example.newsapp.data.source.remote

import com.example.newsapp.data.News
import com.example.newsapp.data.source.asDomainModel
import com.example.newsapp.util.Constants.API_KEY
import com.example.newsapp.util.Constants.COUNTRY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteNewsDataSource(private val service: NewsService) {

    suspend fun getRemoteNews(): List<News> = withContext(Dispatchers.Default) {
        service.getNewsTopHeadlines(COUNTRY, API_KEY).asDomainModel()
    }

}