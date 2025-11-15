package tjk.itservice.examplemulti.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: String,
    val title: String,
    val description: String,
    val date: String
)