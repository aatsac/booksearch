package com.example.booksearch.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteBookEntity(
    @PrimaryKey val key: String,
    val title: String,
    val authors: String,
    val firstPublishYear: Int?,
    val coverId: Long?,
    val savedAt: Long = System.currentTimeMillis()
)
