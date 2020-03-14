package com.example.newsapp.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.News
import com.example.newsapp.data.source.DefaultNewsRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class NewsViewModel @Inject constructor(repository: DefaultNewsRepository) : ViewModel() {

    private val _test = MutableLiveData<List<News>>()
    val test: LiveData<List<News>> = _test

    init {
        viewModelScope.launch {
            _test.value = repository.test()
            Timber.d("Testing ${test}")
        }
    }
}
