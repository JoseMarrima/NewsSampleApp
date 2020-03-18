package com.example.newsapp.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "News")
data class News(@ColumnInfo(name = "title") var title: String? = "",
                @ColumnInfo(name = "urlToImage") var urlToImage: String? = "",
                @ColumnInfo(name = "content") var content: String? = "",
                @PrimaryKey @ColumnInfo(name = "id")
                var id: String = UUID.randomUUID().toString()) : Parcelable