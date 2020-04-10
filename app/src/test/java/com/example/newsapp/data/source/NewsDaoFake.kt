package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.source.local.NewsDao
import kotlinx.coroutines.channels.Channel

class NewsDaoFake(news: List<News>) : NewsDao {
    /**
     * A channel is a Coroutines based implementation of a blocking queue.
     *
     * We're using it here as a buffer of inserted elements.
     *
     * This uses a channel instead of a list to allow multiple threads to call insertComic and
     * synchronize the results with the test thread.
     */
    private val insertedForNext = Channel<List<News>>(capacity = Channel.BUFFERED)

    override suspend fun insertNews(news: List<News>) {
        insertedForNext.send(news)
        _newsLiveData.value = news
    }

    override fun observeNews(): LiveData<List<News>> {
        return _newsLiveData
    }

    private val _newsLiveData = MutableLiveData(news)
}
