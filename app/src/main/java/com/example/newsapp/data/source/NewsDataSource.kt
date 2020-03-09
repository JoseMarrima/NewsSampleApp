package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News

interface NewsDataSource {

    fun observeNews(): LiveData<Result<List<News>>>

}