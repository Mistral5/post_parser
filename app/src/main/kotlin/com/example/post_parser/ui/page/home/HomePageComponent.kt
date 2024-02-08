package com.example.post_parser.ui.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.post_parser.data.DataState
import com.example.post_parser.data.api.ApiService
import com.example.post_parser.ui.component.postList.PostList
import com.example.post_parser.ui.component.postList.PostListComponent
import kotlinx.coroutines.async

class HomePageComponent(
  onAuthorSelected: (authorId: String) -> Unit,
) : HomePage, ViewModel() {
  override val postList: PostList = PostListComponent(onAuthorSelected)
  private val apiService = ApiService()

  override suspend fun getListPost(): DataState {
    return try {
      val data =
        viewModelScope.async {
          apiService.getAllPosts()
        }.await()
      DataState.Success(data)
    } catch (e: Exception) {
      DataState.Error(e)
    }
  }
}
