package tjk.itservice.examplemulti.edit

import com.arkivanov.decompose.value.Value
import tjk.itservice.examplemulti.model.Note

interface EditComponent {

        val model: Value<Note>

        fun onBackPressed()

}