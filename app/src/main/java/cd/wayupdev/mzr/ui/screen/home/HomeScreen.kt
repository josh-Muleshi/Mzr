package cd.wayupdev.mzr.ui.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.ui.screen.home.componant.TopAppBarDropdownMenu

@Composable
fun HomeScreen(navController: NavHostController) {

    val context = LocalContext.current

    BackHandler(enabled = true) {
        (context as? Activity)?.finish()
    }
    Scaffold(
        topBar = {
            TopPageBar(navController)
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}, backgroundColor = MaterialTheme.colors.primary) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp)
        )
        {
            Text(text = "Salut le monde", color = Color.Black, modifier = Modifier.padding(16.dp))
        }
    }
}

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
