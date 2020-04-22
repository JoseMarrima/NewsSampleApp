package com.example.newsapp.di.work

import com.example.newsapp.work.RefreshCacheWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerBindingModule {
    @Binds
    @IntoMap
    @WorkerKey(RefreshCacheWorker::class)
    fun bindRefreshCacheWorker(factory: RefreshCacheWorker.Factory): ChildWorkerFactory
}