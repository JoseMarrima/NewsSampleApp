package com.example.newsapp.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapp.MainCoroutineRule
import com.example.newsapp.data.News
import com.example.newsapp.data.source.FakeTestRepository
import com.example.newsapp.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NewsViewModelTest {
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Subject under test
    private lateinit var newsViewModel: NewsViewModel

    // Use a fake repository to be injected into the viewmodel
    private lateinit var newsRepository: FakeTestRepository

    @Before
    fun setUp() {
        newsRepository = FakeTestRepository()
        newsViewModel = NewsViewModel(newsRepository)
    }

    @Test
    fun addNews_success() {
        val news = News("title", "url", "content")
        newsRepository.addNews(news)

        val value = newsViewModel.news.getOrAwaitValue()

        assertThat(value, not(nullValue()))
    }
}