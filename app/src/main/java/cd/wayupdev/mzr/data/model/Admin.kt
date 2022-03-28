package cd.wayupdev.mzr.data.model

import java.util.*

data class Admin(
    val uid: String = "",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val createdAt: Date? = null
)
