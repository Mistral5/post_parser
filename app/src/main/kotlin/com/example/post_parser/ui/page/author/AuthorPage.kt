package com.example.post_parser.ui.page.author

import com.example.post_parser.data.DataState

interface AuthorPage {
  val authorId: String

  fun onBackButtonClick()

  suspend fun getAuthor(): DataState
}
