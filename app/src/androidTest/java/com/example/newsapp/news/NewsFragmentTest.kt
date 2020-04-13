package com.example.newsapp.news

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.newsapp.data.FakeTestRepository
import com.example.newsapp.data.source.NewsRepository
import org.junit.Before
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class NewsFragmentTest {
    private lateinit var repository: NewsRepository

    @Before
    fun initRepository() {
        repository = FakeTestRepository()
    }


}