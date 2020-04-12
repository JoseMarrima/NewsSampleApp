package com.example.newsapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.newsapp.data.source.local.NewsDatabase
import com.example.newsapp.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class NewsDaoTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NewsDatabase

    @Before
    fun initDB() {
        database = Room.inMemoryDatabaseBuilder(
            getApplicationContext(), NewsDatabase::class.java)
            .allowMainThreadQueries().build()
    }

    @After
    fun closeDB() = database.close()

    @Test
    fun insertNews_andGetNews() = runBlockingTest {
        val news1 = News("title", "url", "content")
        database.newsDao().insertNews(listOf(news1))

        val loaded = database.newsDao().observeNews().getOrAwaitValue()
        assertThat(loaded, notNullValue())
        assertThat(loaded, `is`(listOf(news1)))
    }
}