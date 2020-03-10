package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result

interface NewsRepository {

    fun observeNews(): LiveData<Result<List<News>>>

    suspend fun refreshNews()
}