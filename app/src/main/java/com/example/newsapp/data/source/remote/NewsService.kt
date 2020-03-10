package com.example.newsapp.data.source.remote

import com.example.newsapp.data.source.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getNewsTopHeadlines(@Query("country") country: String,
        @Query("apiKey") apiKey: String) : TopHeadlinesResponse
}