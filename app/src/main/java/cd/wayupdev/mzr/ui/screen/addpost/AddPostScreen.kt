package cd.wayupdev.mzr.ui.screen.addpost

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.ui.screen.topAppBar.AppBarScreen

@Composable
fun AddPostScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
            AppBarScreen(navController,ScreenName = "AddPost")
        }
    ) {
        Text(text = "AddPost")
    }
}