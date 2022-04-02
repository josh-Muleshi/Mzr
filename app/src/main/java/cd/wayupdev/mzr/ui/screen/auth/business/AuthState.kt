package cd.wayupdev.mzr.ui.screen.auth.business

import cd.wayupdev.mzr.data.model.Admin

sealed class AuthState {
    object Uninitialized : AuthState()
    object Loading : AuthState()
    data class Error(val errorMessage: String) : AuthState()
    object Success: AuthState()
}