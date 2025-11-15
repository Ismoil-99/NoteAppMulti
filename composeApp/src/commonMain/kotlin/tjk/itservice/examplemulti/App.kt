package tjk.itservice.examplemulti

    import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

import tjk.itservice.examplemulti.root.RootComponent
import tjk.itservice.examplemulti.root.RootContent

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        RootContent(
            component = rootComponent,
            modifier = Modifier.fillMaxSize()
        )
    }
}