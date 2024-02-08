package com.example.post_parser.ui.page.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.example.post_parser.ui.page.author.AuthorPageComponent
import com.example.post_parser.ui.page.home.HomePageComponent
import kotlinx.serialization.Serializable

class RootComponent(context: ComponentContext) : Root, ComponentContext by context {
  private val navigation = StackNavigation<Config>()

  override val router: Value<ChildStack<*, Root.Child>> =
    childStack(
      source = navigation,
      serializer = Config.serializer(),
      initialConfiguration = Config.HomeChildConfig,
      childFactory = ::child,
    )

  private fun child(
    config: Config,
    context: ComponentContext,
  ): Root.Child =
    when (config) {
      is Config.HomeChildConfig ->
        Root.Child.HomeChild(
          HomePageComponent(
            onAuthorSelected = { userId ->
              navigation.push(Config.AuthorChildConfig(userId))
            },
          ),
        )

      is Config.AuthorChildConfig ->
        Root.Child.AuthorChild(
          AuthorPageComponent(
            authorId = config.authorId,
            onBackButtonSelected = { navigation.pop() },
          ),
        )
    }

  @Serializable
  private sealed interface Config {
    @Serializable
    data object HomeChildConfig : Config

    @Serializable
    data class AuthorChildConfig(val authorId: String) : Config
  }
}
