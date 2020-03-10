package com.example.newsapp.data.source

import com.example.newsapp.data.News
import com.google.gson.annotations.SerializedName

/**
 * This file includes all the data classes from Top-Headlines endpoint
 */

data class TopHeadlinesResponse (
    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<Articles>
)

data class Source (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
)

data class Articles (
    @SerializedName("source") val source : Source,
    @SerializedName("author") val author : String,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("url") val url : String,
    @SerializedName("urlToImage") val urlToImage : String,
    @SerializedName("publishedAt") val publishedAt : String,
    @SerializedName("content") val content : String
)

fun TopHeadlinesResponse.asDomainModel(): List<News> {
    return articles.map {
        News(
            title = it.title,
            urlToImage = it.urlToImage,
            content = it.content
        )
    }
}