package com.example.booksearch.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "api_logs")
data class ApiLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val query: String,
    val resultsCount: Int,
    val success: Boolean,
    val errorMessage: String?,
    val timestamp: Long = System.currentTimeMillis()
)
