package com.example.booksapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booksapp.R
import com.example.booksapp.model.Book

@Composable
fun BooksListScreen(navController: NavController) {
    val books = listOf(
        Book(
            "The Road to Success",
            "Ibrahim El-Feki",
            R.drawable.book1,
            "In this book, Dr. Ibrahim El-Feki reveals the fundamental principles for achieving success through self-development, confidence, and positive thinking."
        ),
        Book(
            "The 7 Habits of Highly Effective People",
            "Stephen Covey",
            R.drawable.book2,
            "This classic book presents seven powerful habits that help individuals balance personal and professional life, become more productive, and live with purpose."
        ),
        Book(
            "The Alchemist",
            "Paulo Coelho",
            R.drawable.book3,
            "A symbolic story about a young Andalusian shepherd who pursues his dream of finding treasure near the pyramids, discovering the true meaning of destiny and self-discovery."
        ),
        Book(
            "Rich Dad Poor Dad",
            "Robert Kiyosaki",
            R.drawable.book4,
            "This book teaches the mindset of the rich and how financial intelligence, investing, and entrepreneurship can lead to financial independence."
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(books) { book ->
            BookItem(book = book, onClick = {
                navController.navigate(
                    "book_detail/${book.title}/${book.author}/${book.imageRes}/${book.description}"
                )
            })
        }
    }
}

@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = book.imageRes),
                contentDescription = book.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "By: ${book.author}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
