package com.example.booksearch.domain.repository

import com.example.booksearch.domain.model.ApiLog
import com.example.booksearch.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>>
    fun getLogs(): Flow<List<ApiLog>>
    suspend fun clearLogs()
    fun getFavorites(): Flow<List<Book>>
    fun isFavorite(key: String): Flow<Boolean>
    suspend fun toggleFavorite(book: Book)
}
