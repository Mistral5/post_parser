package com.example.post_parser.ui.component.postList

import com.arkivanov.decompose.value.Value
import com.example.post_parser.data.model.Post

interface PostList {
  val model: Value<Model>

  fun onAuthorClick(authorId: String)

  data class Model(
    val posts: List<Post>,
  )
}
