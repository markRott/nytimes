package com.example.newyorktimesapp.entities.mostpopular.ui

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_articles")
class ArticleUI(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "uri")
    val uri: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "asset_id")
    val assetId: Long,
    @ColumnInfo(name = "source")
    val source: String,
    @ColumnInfo(name = "published_date")
    val publishedDate: String,
    @ColumnInfo(name = "updated")
    val updated: String,
    @ColumnInfo(name = "byline")
    val byline: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "sub_title")
    val subTitle: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "copyright")
    val copyright: String
)