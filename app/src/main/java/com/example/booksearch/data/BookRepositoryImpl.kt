package com.example.booksearch.data

import com.example.booksearch.data.local.dao.ApiLogDao
import com.example.booksearch.data.local.dao.FavoriteBookDao
import com.example.booksearch.data.local.entity.ApiLogEntity
import com.example.booksearch.data.local.entity.FavoriteBookEntity
import com.example.booksearch.data.remote.api.OpenLibraryApi
import com.example.booksearch.domain.model.ApiLog
import com.example.booksearch.domain.model.Book
import com.example.booksearch.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val api: OpenLibraryApi,
    private val apiLogDao: ApiLogDao,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {

    override suspend fun searchBooks(query: String): Result<List<Book>> {
        return try {
            val response = api.searchBooks(query)
            val books = response.docs.map { dto ->
                Book(
                    key = dto.key,
                    title = dto.title,
                    authors = dto.authorName ?: emptyList(),
                    firstPublishYear = dto.firstPublishYear,
                    coverId = dto.coverId,
                    subjects = dto.subjects?.take(5) ?: emptyList(),
                    pages = dto.pages,
                    ratingsAverage = dto.ratingsAverage,
                    ratingsCount = dto.ratingsCount
                )
            }
            apiLogDao.insert(
                ApiLogEntity(
                    query = query,
                    resultsCount = books.size,
                    success = true,
                    errorMessage = null
                )
            )
            Result.success(books)
        } catch (e: Exception) {
            apiLogDao.insert(
                ApiLogEntity(
                    query = query,
                    resultsCount = 0,
                    success = false,
                    errorMessage = e.message
                )
            )
            Result.failure(e)
        }
    }

    override fun getLogs(): Flow<List<ApiLog>> =
        apiLogDao.getAllLogs().map { list ->
            list.map { entity ->
                ApiLog(
                    id = entity.id,
                    query = entity.query,
                    resultsCount = entity.resultsCount,
                    success = entity.success,
                    errorMessage = entity.errorMessage,
                    timestamp = entity.timestamp
                )
            }
        }

    override suspend fun clearLogs() = apiLogDao.clearAll()

    override fun getFavorites(): Flow<List<Book>> =
        favoriteBookDao.getAllFavorites().map { list ->
            list.map { entity ->
                Book(
                    key = entity.key,
                    title = entity.title,
                    authors = entity.authors.split(", "),
                    firstPublishYear = entity.firstPublishYear,
                    coverId = entity.coverId,
                    subjects = emptyList(),
                    pages = null,
                    ratingsAverage = null,
                    ratingsCount = null
                )
            }
        }

    override fun isFavorite(key: String): Flow<Boolean> =
        favoriteBookDao.isFavorite(key)

    override suspend fun toggleFavorite(book: Book) {
        val alreadyFavorite = favoriteBookDao.isFavorite(book.key).first()
        val entity = FavoriteBookEntity(
            key = book.key,
            title = book.title,
            authors = book.authorsDisplay,
            firstPublishYear = book.firstPublishYear,
            coverId = book.coverId
        )
        if (alreadyFavorite) {
            favoriteBookDao.delete(entity)
        } else {
            favoriteBookDao.insert(entity)
        }
    }
}
