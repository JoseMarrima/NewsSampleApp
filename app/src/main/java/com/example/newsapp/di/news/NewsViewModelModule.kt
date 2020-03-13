package com.example.newsapp.di.news

import androidx.lifecycle.ViewModel
import com.example.newsapp.di.ViewModelKey
import com.example.newsapp.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel
}
