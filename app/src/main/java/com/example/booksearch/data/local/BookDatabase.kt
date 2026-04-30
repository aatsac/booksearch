package com.example.booksearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.booksearch.data.local.dao.ApiLogDao
import com.example.booksearch.data.local.dao.FavoriteBookDao
import com.example.booksearch.data.local.entity.ApiLogEntity
import com.example.booksearch.data.local.entity.FavoriteBookEntity

@Database(
    entities = [ApiLogEntity::class, FavoriteBookEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun apiLogDao(): ApiLogDao
    abstract fun favoriteBookDao(): FavoriteBookDao
}
