package tjk.itservice.examplemulti.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.detail.AddComponent
import tjk.itservice.examplemulti.edit.EditComponent
import tjk.itservice.examplemulti.main.MainComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Main(val component: MainComponent) : Child
        class Detail(val component: AddComponent) : Child
        class Edit(val component: EditComponent): Child
    }
}