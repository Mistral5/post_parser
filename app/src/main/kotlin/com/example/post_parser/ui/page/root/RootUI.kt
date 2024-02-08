package com.example.post_parser.ui.page.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.example.post_parser.ui.page.author.AuthorPageUI
import com.example.post_parser.ui.page.home.HomePageUI

@Composable
fun RootUI(component: RootComponent) {
  Children(
    stack = component.router,
    animation = stackAnimation(slide()),
  ) {
    when (val child = it.instance) {
      is Root.Child.HomeChild -> HomePageUI(child.component)
      is Root.Child.AuthorChild -> AuthorPageUI(child.component)
    }
  }
}
