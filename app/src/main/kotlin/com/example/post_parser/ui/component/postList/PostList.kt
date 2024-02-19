package com.example.post_parser.ui.component.postList

import com.arkivanov.decompose.value.Value
import com.example.post_parser.data.DataState
import com.example.post_parser.data.model.Post

interface PostList {
  data class Model(
    val posts: DataState<List<Post>>,
  )

  val model: Value<Model>

  fun onAuthorClick(authorId: String)

  suspend fun getListPost()
}
