package com.example.booksearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksearch.domain.model.ApiLog
import com.example.booksearch.domain.model.Book
import com.example.booksearch.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface SearchUiState {
    data object Idle : SearchUiState
    data object Loading : SearchUiState
    data class Success(val books: List<Book>) : SearchUiState
    data class Error(val message: String) : SearchUiState
}

@HiltViewModel
class BookViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {

    private val _searchState = MutableStateFlow<SearchUiState>(SearchUiState.Idle)
    val searchState: StateFlow<SearchUiState> = _searchState.asStateFlow()

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    val logs: StateFlow<List<ApiLog>> = repository.getLogs()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val favorites: StateFlow<List<Book>> = repository.getFavorites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun onQueryChange(value: String) {
        _query.value = value
    }

    fun search() {
        val q = _query.value.trim()
        if (q.isBlank()) return
        viewModelScope.launch {
            _searchState.value = SearchUiState.Loading
            val result = repository.searchBooks(q)
            _searchState.value = result.fold(
                onSuccess = { books ->
                    if (books.isEmpty()) SearchUiState.Error("Nenhum livro encontrado para \"$q\"")
                    else SearchUiState.Success(books)
                },
                onFailure = { e ->
                    SearchUiState.Error(e.message ?: "Erro desconhecido")
                }
            )
        }
    }

    fun isFavorite(key: String): StateFlow<Boolean> =
        repository.isFavorite(key)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    fun toggleFavorite(book: Book) {
        viewModelScope.launch {
            repository.toggleFavorite(book)
        }
    }

    fun clearLogs() {
        viewModelScope.launch { repository.clearLogs() }
    }
}
