package com.dheeraj.postapi.client

import com.dheeraj.postapi.model.Post
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val httpClient = HttpClient {
        install(JsonFeature)
    }

    suspend fun getPosts(): List<Post> {
        return httpClient.get<List<Post>>("$BASE_URL/posts")
    }
}
