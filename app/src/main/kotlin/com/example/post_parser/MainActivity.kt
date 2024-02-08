package com.example.post_parser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.example.post_parser.ui.page.root.RootComponent
import com.example.post_parser.ui.page.root.RootUI
import com.example.post_parser.ui.theme.Post_parserTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val rootComponent = RootComponent(defaultComponentContext())

    setContent {
      Post_parserTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background,
        ) {
          RootUI(rootComponent)
        }
      }
    }
  }
}
