package cd.wayupdev.mzr.app.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cd.wayupdev.mzr.ui.screen.home.HomeScreen
import cd.wayupdev.mzr.ui.screen.splash.SplashScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

    }
}