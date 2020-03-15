package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.Result.*
import com.example.newsapp.data.source.local.LocalNewsDataSource
import com.example.newsapp.data.source.remote.RemoteNewsDataSource
import timber.log.Timber


class DefaultNewsRepository(
    private val remoteNewsDataSource: RemoteNewsDataSource,
    private val localNewsDataSource: LocalNewsDataSource
) : NewsRepository {

    override fun observeNews(): LiveData<List<News>> = liveData {
        emitSource(localNewsDataSource.observeNews())
    }

    override suspend fun refreshNews() {
        val news = remoteNewsDataSource.getRemoteNews()
        localNewsDataSource.saveNews(news)
    }


}