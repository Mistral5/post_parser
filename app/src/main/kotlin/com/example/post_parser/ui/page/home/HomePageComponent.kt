package com.example.post_parser.ui.page.home

import com.example.post_parser.ui.component.postList.PostList
import com.example.post_parser.ui.component.postList.PostListComponent

class HomePageComponent(
  onAuthorSelected: (authorId: String) -> Unit,
) : HomePage {
  override val postList: PostList = PostListComponent(onAuthorSelected)
}
