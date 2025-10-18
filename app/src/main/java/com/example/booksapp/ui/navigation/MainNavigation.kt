package com.example.booksapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booksapp.ui.screens.BooksListScreen
import com.example.booksapp.ui.screens.SettingsScreen
import com.example.booksapp.ui.screens.BookDetailScreen
import com.example.booksapp.model.Book

@Composable
fun MainNavigation(navController: NavHostController) {
    val items = listOf(
        NavigationItem("books", "Books", Icons.Default.Book),
        NavigationItem("settings", "Settings", Icons.Default.Settings)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = false,
                        onClick = { navController.navigate(item.route) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "books",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("books") { BooksListScreen(navController) }
            composable("settings") { SettingsScreen() }

            // ✅ Book Detail Screen
            composable("book_detail/{title}/{author}/{imageRes}/{description}") { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title") ?: ""
                val author = backStackEntry.arguments?.getString("author") ?: ""
                val imageRes = backStackEntry.arguments?.getString("imageRes")?.toIntOrNull() ?: 0
                val description = backStackEntry.arguments?.getString("description") ?: ""

                val book = Book(title, author, imageRes, description)
                BookDetailScreen(navController, book)
            }
        }
    }
}

data class NavigationItem(
    val route: String,
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
