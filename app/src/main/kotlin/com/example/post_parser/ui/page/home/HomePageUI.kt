package com.example.post_parser.ui.page.home

import PostListUI
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.post_parser.ui.theme.Pink

@Composable
fun HomePageUI(component: HomePage) {
  Column(
    modifier =
      Modifier
        .fillMaxSize()
        .background(Pink)
        .padding(horizontal = 12.dp),
  ) {
    PostListUI(component.postList)
  }
}

// @Preview
// @Composable
// fun HomeScreenPreview() {
//  HomePage()
// }
