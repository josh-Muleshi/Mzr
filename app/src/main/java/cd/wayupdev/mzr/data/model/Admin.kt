package cd.wayupdev.mzr.data.model

import java.util.*

data class Admin(
    val uid: String = "",
    val email: String = "",
    val password: String = "",
    val createdAt: Date? = null
)
