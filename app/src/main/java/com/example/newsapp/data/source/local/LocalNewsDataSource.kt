package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.source.NewsDataSource

class LocalNewsDataSource : NewsDataSource {
    override fun observeNews(): LiveData<Result<List<News>>> {

    }
}