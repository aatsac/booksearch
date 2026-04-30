package com.example.booksearch.domain.model

data class Book(
    val key: String,
    val title: String,
    val authors: List<String>,
    val firstPublishYear: Int?,
    val coverId: Long?,
    val subjects: List<String>,
    val pages: Int?,
    val ratingsAverage: Double?,
    val ratingsCount: Int?
) {
    val coverUrl: String?
        get() = coverId?.let { "https://covers.openlibrary.org/b/id/$it-M.jpg" }

    val authorsDisplay: String
        get() = authors.take(3).joinToString(", ").ifEmpty { "Autor desconhecido" }
}

data class ApiLog(
    val id: Long,
    val query: String,
    val resultsCount: Int,
    val success: Boolean,
    val errorMessage: String?,
    val timestamp: Long
)
