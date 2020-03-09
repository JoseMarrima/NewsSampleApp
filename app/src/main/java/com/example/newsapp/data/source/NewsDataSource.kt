package com.example.newsapp.data.source

import androidx.lifecycle.LiveData
import com.example.newsapp.data.News
import com.example.newsapp.data.Result

interface NewsDataSource {

    fun observeNews(): LiveData<Result<List<News>>>

}