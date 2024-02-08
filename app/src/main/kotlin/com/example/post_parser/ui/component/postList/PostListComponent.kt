package com.example.post_parser.ui.component.postList

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class PostListComponent(
  private val onAuthorSelected: (authorId: String) -> Unit,
) : PostList {
  private val _model = MutableValue(PostList.Model(mutableListOf()))
  override val model: Value<PostList.Model>
    get() = _model

  override fun onAuthorClick(authorId: String) {
    onAuthorSelected(authorId)
  }
}
