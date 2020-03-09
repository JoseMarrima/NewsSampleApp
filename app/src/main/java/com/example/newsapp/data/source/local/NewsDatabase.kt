package com.example.newsapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.data.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao() : NewsDao
}