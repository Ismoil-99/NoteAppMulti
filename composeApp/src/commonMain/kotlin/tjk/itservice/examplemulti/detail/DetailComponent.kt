package tjk.itservice.examplemulti.detail

import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

interface DetailComponent {
    val model: Value<Note>

    fun onBackPressed()
}