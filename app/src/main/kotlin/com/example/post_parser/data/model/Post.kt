package com.example.post_parser.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
  val id: Int,
  val title: String,
  val body: String,
  val userId: String,
)
