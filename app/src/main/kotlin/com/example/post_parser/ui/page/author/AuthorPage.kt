package com.example.post_parser.ui.page.author

import com.arkivanov.decompose.value.Value
import com.example.post_parser.data.DataState
import com.example.post_parser.data.model.Author

interface AuthorPage {
  data class Model(
    val author: DataState<Author>,
  )

  val model: Value<Model>

  val authorId: String

  fun onBackButtonClick()

  suspend fun getAuthor()
}
