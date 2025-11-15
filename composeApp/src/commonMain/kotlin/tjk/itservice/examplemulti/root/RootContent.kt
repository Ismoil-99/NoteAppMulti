package tjk.itservice.examplemulti.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import tjk.itservice.examplemulti.detail.NoteDetailScreen
import tjk.itservice.examplemulti.edit.NoteEditScreen
import tjk.itservice.examplemulti.main.MainScreen

@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Main -> MainScreen(component = child.component,modifier)
            is RootComponent.Child.Detail -> NoteDetailScreen(component = child.component,modifier)
            is RootComponent.Child.Edit -> NoteEditScreen(component = child.component,modifier)
        }
    }
}