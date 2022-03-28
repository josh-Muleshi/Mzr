package cd.wayupdev.mzr.data.model

import java.util.*

data class Post(
    val uid: String = "",
    val title: String = "",
    val adminUid: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val createdAt: Date? = null
)