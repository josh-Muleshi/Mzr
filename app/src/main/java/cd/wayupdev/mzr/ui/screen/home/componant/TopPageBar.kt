package cd.wayupdev.mzr.ui.screen.home.componant

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TopPageBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                text = "AuthBoy Mzr",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, "menu")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp,
        actions = {
            TopAppBarDropdownMenu(navController)
        }
    )
}