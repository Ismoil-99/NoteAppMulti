package tjk.itservice.examplemulti.detail

import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

interface AddComponent {
    val model: Value<Note>

    fun onBackPressed()

    fun editNote(note: Note)
}