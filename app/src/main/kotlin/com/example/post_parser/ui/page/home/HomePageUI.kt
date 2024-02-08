package com.example.post_parser.ui.page.home

import PostListUI
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.post_parser.data.DataState
import com.example.post_parser.data.model.Post
import com.example.post_parser.ui.theme.ItimTypography
import com.example.post_parser.ui.theme.Pink
import com.example.post_parser.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun HomePageUI(component: HomePage) {
  val coroutineScope = rememberCoroutineScope()
  val dataState = remember { mutableStateOf<DataState>(DataState.Loading) }

  fun updatePosts() = coroutineScope.launch { dataState.value = component::getListPost.invoke() }

  LaunchedEffect(Unit) {
    updatePosts()
  }

  when (val state = dataState.value) {
    is DataState.Loading -> {
      Column(
        modifier =
          Modifier
            .background(Pink)
            .padding(horizontal = 12.dp),
      ) {
        PostListUI(component.postList)
      }
    }

    is DataState.Success<*> -> {
      Column(
        modifier =
          Modifier
            .background(Pink)
            .padding(horizontal = 12.dp),
      ) {
        PostListUI(component.postList, state.data as List<Post>?)
      }
    }

    is DataState.Error -> {
      Column(
        modifier = Modifier.padding(vertical = 12.dp),
      ) {
        ElevatedCard {
          Column(modifier = Modifier.padding(12.dp)) {
            state.exception.localizedMessage?.let {
              Text(
                text = it,
                style = ItimTypography.bodyMedium,
                color = White,
              )
            }
          }
        }
      }
    }
  }
}

// @Preview
// @Composable
// fun HomeScreenPreview() {
//  HomePage()
// }
