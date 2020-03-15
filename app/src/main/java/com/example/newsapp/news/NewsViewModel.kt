package com.example.newsapp.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.News
import com.example.newsapp.data.source.DefaultNewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(repository: DefaultNewsRepository) : ViewModel() {

    private val _news: LiveData<List<News>> = repository.observeNews()
    val news: LiveData<List<News>> = _news

    init {
        viewModelScope.launch {
            repository.refreshNews()
        }
    }

}
