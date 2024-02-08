package com.example.post_parser.ui.page.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.post_parser.ui.page.author.AuthorPage
import com.example.post_parser.ui.page.home.HomePage

interface Root {
  val router: Value<ChildStack<*, Child>>

  sealed interface Child {
    class HomeChild(val component: HomePage) : Child

    class AuthorChild(val component: AuthorPage) : Child
  }
}
