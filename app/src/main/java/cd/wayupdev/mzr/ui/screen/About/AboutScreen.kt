package cd.wayupdev.mzr.ui.screen.About

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.ui.screen.TopAppBar.AppBarScreen

@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppBarScreen(navController,ScreenName = "About us")
        }
    ){
        Text(text = "About us", modifier = Modifier.padding(16.dp), color = Color.Black)
    }
}