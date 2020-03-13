package com.example.newsapp.di.newsdetails

import androidx.lifecycle.ViewModel
import com.example.newsapp.di.ViewModelKey
import com.example.newsapp.newsdetails.NewsDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsViewModel::class)
    abstract fun bindNewsDetailsViewModel(newsDetailsViewModel: NewsDetailsViewModel): ViewModel
}
