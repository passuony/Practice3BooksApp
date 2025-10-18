package com.example.booksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.booksapp.ui.navigation.MainNavigation
import com.example.booksapp.ui.theme.BooksAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksAppTheme {
                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    BooksAppTheme {
        Text("Books App")
    }
}
