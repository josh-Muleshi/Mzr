package cd.wayupdev.mzr.ui.screen.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.app.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true){
        delay(2000)
        navController.navigate(Screen.Home.route)
    }
    Text(text = "Splash", color = Color.Black)
}