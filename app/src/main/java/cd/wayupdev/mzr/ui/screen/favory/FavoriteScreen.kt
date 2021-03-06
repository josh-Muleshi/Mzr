package cd.wayupdev.mzr.ui.screen.favory

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.ui.screen.topAppBar.AppBarScreen

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppBarScreen(navController, ScreenName = "Favorite")
        }
    ){
        Text(text = "Favorite", modifier = Modifier.padding(16.dp), color = Color.Black)
    }
}