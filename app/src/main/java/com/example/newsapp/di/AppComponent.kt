package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.NewsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    ViewModelFactoryModule::class,
    FragmentBuilderModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<NewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context) : AppComponent
    }
}