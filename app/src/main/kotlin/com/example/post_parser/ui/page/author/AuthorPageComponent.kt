package com.example.post_parser.ui.page.author

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.post_parser.data.DataState
import com.example.post_parser.data.api.ApiService
import kotlinx.coroutines.async

class AuthorPageComponent(
  override val authorId: String,
  private val onBackButtonSelected: () -> Unit,
) : AuthorPage, ViewModel() {
  private val _model = MutableValue(AuthorPage.Model(DataState.Loading))

  override val model: Value<AuthorPage.Model>
    get() = _model

  override fun onBackButtonClick() {
    onBackButtonSelected()
  }

  override suspend fun getAuthor() {
    try {
      val data =
        viewModelScope.async {
          ApiService().getAuthorById(authorId)
        }.await()
      _model.update { it.copy(author = DataState.Success(data)) }
    } catch (e: Exception) {
      _model.update { it.copy(author = DataState.Error(e)) }
    }
  }
}
