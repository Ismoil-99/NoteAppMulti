package tjk.itservice.examplemulti.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

class DefaultMainComponent(
    componentContext: ComponentContext,
    private val postClicked: (Note) -> Unit,
) : MainComponent, ComponentContext by componentContext {
    override val model: Value<List<Note>> = MutableValue(
        (0..16).map {
            Note(
                id = it.toString(),
                title = "Title-#$it",
                description = "pldsmpvlm",
                date = "2020-02-09",
            )
        }
    )

    override fun onNoteClicked(post: Note) {
        postClicked(post)
    }
}