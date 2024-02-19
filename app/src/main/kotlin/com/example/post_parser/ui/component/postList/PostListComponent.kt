package com.example.post_parser.ui.component.postList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.post_parser.data.DataState
import com.example.post_parser.data.api.ApiService
import kotlinx.coroutines.async

class PostListComponent(
  private val onAuthorSelected: (authorId: String) -> Unit,
) : PostList, ViewModel() {
  private val _model = MutableValue(PostList.Model(DataState.Loading))

  override val model: Value<PostList.Model>
    get() = _model

  override fun onAuthorClick(authorId: String) {
    onAuthorSelected(authorId)
  }

  override suspend fun getListPost() {
    try {
      val data =
        viewModelScope.async {
          ApiService().getAllPosts()
        }.await()
      _model.update { it.copy(posts = DataState.Success(data)) }
    } catch (e: Exception) {
      _model.update { it.copy(posts = DataState.Error(e)) }
    }
  }
}
