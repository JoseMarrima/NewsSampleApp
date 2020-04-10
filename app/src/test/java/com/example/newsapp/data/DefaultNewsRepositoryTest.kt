package com.example.newsapp.data

import com.example.newsapp.data.source.DefaultNewsRepository
import com.example.newsapp.data.source.NewsDaoFake
import com.example.newsapp.data.source.NewsServiceFake
import com.example.newsapp.data.source.TopHeadlinesResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.mock
import com.google.common.truth.Truth.assertThat


@ExperimentalCoroutinesApi
class DefaultNewsRepositoryTest {

    private val news1 = News("title1", "url1", "content1")
    private val news2 = News("title2", "url2", "content2")
    private val news3 = News("title3", "url3", "content3")

    private val news = listOf(news1, news2, news3).sortedBy { it.id }

    @Test
    fun when_getNewsFromNet_insertInDatabase() = runBlockingTest {
        val topHeadlinesResponse = mock(TopHeadlinesResponse::class.java)
        val subject = DefaultNewsRepository(NewsServiceFake(topHeadlinesResponse),
            NewsDaoFake(news))

        assertThat(subject.newsDao.observeNews().value.toString()).isEqualTo(news.toString())
    }
}