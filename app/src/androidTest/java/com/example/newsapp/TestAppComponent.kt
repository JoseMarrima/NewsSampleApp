package com.example.newsapp

import android.content.Context
import com.example.newsapp.data.source.NewsRepository
import com.example.newsapp.di.FragmentBuilderModule
import com.example.newsapp.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestApplicationModule::class,
    ViewModelFactoryModule::class,
    FragmentBuilderModule::class,
    AndroidSupportInjectionModule::class])
interface TestAppComponent: AndroidInjector<TestNewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

    val newsRepository: NewsRepository
}