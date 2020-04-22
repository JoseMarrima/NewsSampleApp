package com.example.newsapp

import androidx.work.*
import com.example.newsapp.di.DaggerAppComponent
import com.example.newsapp.di.work.SampleWorkerFactory
import com.example.newsapp.work.RefreshCacheWorker
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

open class NewsApplication : DaggerApplication() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(applicationContext)
    }
    override fun onCreate() {
        super.onCreate()
        // register ours custom factory to WorkerManager
        val workerFactory: SampleWorkerFactory = DaggerAppComponent.factory().create(applicationContext).workerFactory()
        WorkManager.initialize(this, Configuration.Builder().setWorkerFactory(workerFactory).build())
        delayedInit()
    }

    /**
     * Setup WorkManager background job to 'fetch' new network data daily.
     */
    private fun setupRecurringWork() {

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true).build()

        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshCacheWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        Timber.d("WorkManager: Periodic Work request for sync is scheduled")
        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshCacheWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }

    private fun delayedInit() {
        applicationScope.launch {
            Timber.plant(Timber.DebugTree())
            setupRecurringWork()
        }
    }
}