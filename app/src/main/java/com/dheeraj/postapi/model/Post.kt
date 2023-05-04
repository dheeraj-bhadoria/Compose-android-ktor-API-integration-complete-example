package com.dheeraj.postapi.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

