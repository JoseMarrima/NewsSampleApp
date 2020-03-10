package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result
import com.example.newsapp.data.Result.*
import com.example.newsapp.data.source.local.LocalNewsDataSource
import com.example.newsapp.data.source.remote.RemoteNewsDataSource


class DefaultNewsRepository(
    private val remoteNewsDataSource: RemoteNewsDataSource,
    private val localNewsDataSource: LocalNewsDataSource
) : NewsRepository {

    override fun observeNews(): LiveData<Result<List<News>>> {
        return localNewsDataSource.observeNews()
    }

    override suspend fun refreshNews() {
        val remoteNews = remoteNewsDataSource.getRemoteNews()

        if (remoteNews is Success) {
            localNewsDataSource.saveNews(remoteNews.data)
        } else if (remoteNews is Error) {
            throw remoteNews.exception
        }
    }


}