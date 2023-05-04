package com.dheeraj.postapi

import com.dheeraj.postapi.model.Post
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dheeraj.postapi.client.ApiClient
import com.dheeraj.postapi.ui.theme.PostAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppView()
                }
            }
        }
    }
}

@Composable
fun AppView() {
    Column(){
        PostList();
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostAPITheme {
        AppView()
    }
}


@Composable
fun PostList() {
    var posts by remember { mutableStateOf(emptyList<Post>()) }

    LaunchedEffect(Unit) {
        posts = ApiClient.getPosts()
    }

    Column() {
        LazyColumn {
            items(posts) { post ->
                PostItem(post = post)
            }
        }
    }

}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = post.body)
    }
}
