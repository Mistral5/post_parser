package com.example.post_parser.ui.page.home

import com.example.post_parser.data.DataState
import com.example.post_parser.ui.component.postList.PostList

interface HomePage {
  val postList: PostList

  suspend fun getListPost(): DataState
}
