package com.example.newsapp.data.source

import com.example.newsapp.data.source.remote.NewsService

/**
 * Testing Fake implementation of NewsService
 */
class NewsServiceFake(var result: TopHeadlinesResponse) : NewsService {
    override suspend fun getNewsTopHeadlines(country: String,
                                    apiKey: String) = result
}
