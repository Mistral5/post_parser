package com.example.post_parser.ui.page.author

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.post_parser.data.DataState
import com.example.post_parser.data.api.ApiService
import kotlinx.coroutines.async

class AuthorPageComponent(
  override val authorId: String,
  private val onBackButtonSelected: () -> Unit,
) : AuthorPage, ViewModel() {
  override fun onBackButtonClick() {
    onBackButtonSelected()
  }

  private val apiService = ApiService()

  override suspend fun getAuthor(): DataState {
    return try {
      val data =
        viewModelScope.async {
          apiService.getAuthorById(authorId)
        }.await()
      DataState.Success(data)
    } catch (e: Exception) {
      DataState.Error(e)
    }
  }
}
