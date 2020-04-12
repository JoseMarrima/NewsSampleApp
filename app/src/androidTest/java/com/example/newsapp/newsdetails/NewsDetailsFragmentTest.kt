package com.example.newsapp.newsdetails

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.newsapp.DaggerTestApplicationRule
import com.example.newsapp.R
import com.example.newsapp.data.News
import com.example.newsapp.data.FakeTestRepository
import com.example.newsapp.data.source.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@MediumTest
@RunWith(AndroidJUnit4::class)
class NewsDetailsFragmentTest {

    private lateinit var repository: NewsRepository

    /**
     * Sets up Dagger components for testing.
     */
    @get:Rule
    val rule = DaggerTestApplicationRule()

    @Before
    fun setupDaggerComponent() {
        repository = rule.component.newsRepository
    }

    @Test
    fun newsDetails_DisplayedInUi() = runBlockingTest {
        // GIVEN - Add completed task to the DB
        val new = News("title", "url", "content")
        repository.refreshNews()

        // WHEN - Details fragment launched to display task
        val bundle = NewsDetailsFragmentArgs(new).toBundle()
        launchFragmentInContainer<NewsDetailsFragment>(bundle, R.style.AppTheme)

        onView(withId(R.id.description_textView)).check(matches(withText("content")))
    }
}