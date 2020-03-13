package com.example.newsapp.di

import com.example.newsapp.di.news.NewsViewModelModule
import com.example.newsapp.di.newsdetails.NewsDetailsViewModelModule
import com.example.newsapp.news.NewsFragment
import com.example.newsapp.newsdetails.NewsDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(modules = [NewsViewModelModule::class])
    abstract fun contributeNewsFragment() : NewsFragment

    @ContributesAndroidInjector(modules = [NewsDetailsViewModelModule::class])
    abstract fun contributeNewsDetailsFragment() : NewsDetailsFragment
}