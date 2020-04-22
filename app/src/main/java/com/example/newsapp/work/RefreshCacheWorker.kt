package com.example.newsapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.newsapp.data.source.NewsRepository
import com.example.newsapp.di.work.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class RefreshCacheWorker @AssistedInject constructor(@Assisted appContext: Context,
                                                     @Assisted params: WorkerParameters,
                                                     private val repository: NewsRepository):
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "com.example.newsapp.work.RefreshCacheWorker"
    }

    override suspend fun doWork(): Result {
        try {
            repository.refreshNews()
            Timber.d("WorkManager: Work request for sync is run")
        } catch (e: HttpException) {
            return Result.retry()
        }
        return Result.success()
    }

    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory
}