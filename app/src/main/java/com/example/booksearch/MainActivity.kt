package com.example.booksearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksearch.ui.screens.MainNavigation
import com.example.booksearch.ui.theme.BookSearchTheme
import com.example.booksearch.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookSearchTheme {
                val viewModel: BookViewModel = hiltViewModel()
                MainNavigation(viewModel)
            }
        }
    }
}
