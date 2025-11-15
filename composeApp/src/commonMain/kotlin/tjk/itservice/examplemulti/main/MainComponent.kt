package tjk.itservice.examplemulti.main

import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

interface MainComponent {
    val model: Value<List<Note>>

    fun onNoteClicked(post: Note)
}