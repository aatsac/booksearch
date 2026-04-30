package com.example.booksearch.data.remote.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("numFound") val numFound: Int = 0,
    @SerializedName("docs") val docs: List<BookDto> = emptyList()
)

data class BookDto(
    @SerializedName("key") val key: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("author_name") val authorName: List<String>? = null,
    @SerializedName("first_publish_year") val firstPublishYear: Int? = null,
    @SerializedName("cover_i") val coverId: Long? = null,
    @SerializedName("subject") val subjects: List<String>? = null,
    @SerializedName("number_of_pages_median") val pages: Int? = null,
    @SerializedName("ratings_average") val ratingsAverage: Double? = null,
    @SerializedName("ratings_count") val ratingsCount: Int? = null
)
