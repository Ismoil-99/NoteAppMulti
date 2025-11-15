package tjk.itservice.examplemulti.edit

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

class DefaultEditComponent(
    componentContext: ComponentContext,
    post: Note,
    private val onFinished: () -> Unit,
) : EditComponent, ComponentContext by componentContext {

    override val model: Value<Note> = MutableValue(post)

    override fun onBackPressed() = onFinished()
}