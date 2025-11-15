package tjk.itservice.examplemulti.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import tjk.itservice.examplemulti.detail.DefaultAddComponent
import tjk.itservice.examplemulti.edit.DefaultEditComponent
import tjk.itservice.examplemulti.main.DefaultMainComponent
import tjk.itservice.examplemulti.model.Note

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val nav = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = nav,
        serializer = Config.serializer(),
        initialConfiguration = Config.List,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {

        Config.List -> RootComponent.Child.Main(
            DefaultMainComponent(
                componentContext = componentContext,
                postClicked = { post -> nav.pushNew(Config.Detail(post)) }
            )
        )

        is Config.Detail -> RootComponent.Child.Detail(
            DefaultAddComponent(
                componentContext = componentContext,
                post = config.post,
                onFinished = { nav.pop() },
                onEditeNote = { note ->
                    nav.pushNew(Config.Edit(note))
                }
            )
        )
        is Config.Edit -> RootComponent.Child.Edit(
            DefaultEditComponent(
                componentContext = componentContext,
                post = config.post,
                onFinished = { nav.pop() },
        ))
    }


    @kotlinx.serialization.Serializable
    private sealed interface Config {
        @kotlinx.serialization.Serializable
        data object List : Config

        @Serializable
        data class Detail(val post: Note) : Config
        @Serializable
        data class Edit(val post: Note) : Config
    }
}