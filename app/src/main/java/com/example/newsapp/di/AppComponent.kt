package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.NewsApplication
import com.example.newsapp.di.work.SampleWorkerFactory
import com.example.newsapp.di.work.WorkerBindingModule
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    SampleAssistedInjectModule::class,
    ViewModelFactoryModule::class,
    FragmentBuilderModule::class,
    WorkerBindingModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<NewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context) : AppComponent
    }
    fun workerFactory(): SampleWorkerFactory
}

@Module(includes = [AssistedInject_SampleAssistedInjectModule::class])
@AssistedModule
interface SampleAssistedInjectModule