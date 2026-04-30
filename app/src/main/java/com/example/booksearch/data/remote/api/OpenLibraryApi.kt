package com.example.booksearch.data.remote.api

import com.example.booksearch.data.remote.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {

    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int = 20,
        @Query("fields") fields: String = "key,title,author_name,first_publish_year,cover_i,subject,number_of_pages_median,ratings_average,ratings_count"
    ): SearchResponse
}
