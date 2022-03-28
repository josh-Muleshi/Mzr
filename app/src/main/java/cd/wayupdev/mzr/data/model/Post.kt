package cd.wayupdev.mzr.data.model

import java.util.*

data class Post(
    val uid: String = "",
    val name: String = "",
    val userUid: String = "",
    val description: String = "",
    val createdAt: Date? = null
)