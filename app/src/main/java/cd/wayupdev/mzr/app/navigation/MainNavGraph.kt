package cd.wayupdev.mzr.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cd.wayupdev.mzr.ui.screen.About.AboutScreen
import cd.wayupdev.mzr.ui.screen.home.HomeScreen
import cd.wayupdev.mzr.ui.screen.settings.SettingScreen
import cd.wayupdev.mzr.ui.screen.splash.SplashScreen

@Composable
fun MainNavGraph(navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.About.route){
            AboutScreen()
        }

        composable(Screen.Settings.route){
            SettingScreen()
        }
    }
}