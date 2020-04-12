package com.example.newsapp.newsdetails

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.newsapp.R
import com.example.newsapp.data.News
import com.example.newsapp.data.FakeTestRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@MediumTest
@RunWith(AndroidJUnit4::class)
class NewsDetailsFragmentTest {

    private lateinit var repository: FakeTestRepository

    @Before
    fun initRepository() {
        repository = FakeTestRepository()
    }

    @Test
    fun newsDetails_DisplayedInUi() = runBlockingTest {
        // GIVEN - Add completed task to the DB
        val new = News("title", "url", "content")
        repository.addNews(new)

        // WHEN - Details fragment launched to display task
        val bundle = NewsDetailsFragmentArgs(new).toBundle()
        launchFragmentInContainer<NewsDetailsFragment>(bundle, R.style.AppTheme)
    }
}