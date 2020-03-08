package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News

interface NewsDataSource {

    fun observeTasks(): LiveData<Result<List<News>>>

}