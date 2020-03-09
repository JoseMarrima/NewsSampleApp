package com.example.newsapp.data.source.remote

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.source.NewsDataSource

class RemoteNewsDataSource : NewsDataSource {
    override fun observeNews(): LiveData<Result<List<News>>> {

    }

}