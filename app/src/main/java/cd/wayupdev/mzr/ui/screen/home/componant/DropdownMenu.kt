package cd.wayupdev.mzr.ui.screen.home.componant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.app.navigation.Screen

@Composable
fun TopAppBarDropdownMenu(navController: NavHostController) {

    val expanded = remember { mutableStateOf(false) }

    Box(
        Modifier
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = {
            expanded.value = true
        }) {
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = "More Menu"
            )
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
    ) {
        DropdownMenuItem(onClick = {
            expanded.value = false
            navController.navigate(Screen.Settings.route)
        }) {
            Text("Settings")
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            navController.navigate(Screen.About.route)
        }) {
            Text("About us")
        }
    }
}