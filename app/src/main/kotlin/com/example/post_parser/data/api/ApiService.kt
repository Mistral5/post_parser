package com.example.post_parser.data.api

import com.example.post_parser.data.api.HttpClientFactory.httpClient
import com.example.post_parser.data.model.Author
import com.example.post_parser.data.model.Post
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService {
  suspend fun getAllPosts(): List<Post> = httpClient.get("/posts").body<List<Post>>()

  suspend fun getAuthorById(authorId: String): Author = httpClient.get("/users/$authorId").body<Author>()
}
