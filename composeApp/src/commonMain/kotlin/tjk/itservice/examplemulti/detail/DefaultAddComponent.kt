package tjk.itservice.examplemulti.detail

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

class DefaultAddComponent(
    componentContext: ComponentContext,
    post: Note,
    private val onFinished: () -> Unit,
) : AddComponent, ComponentContext by componentContext {

    override val model: Value<Note> = MutableValue(post)

    override fun onBackPressed() = onFinished()
}