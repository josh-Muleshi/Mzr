package cd.wayupdev.mzr.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cd.wayupdev.mzr.ui.screen.about.AboutScreen
import cd.wayupdev.mzr.ui.screen.addpost.AddPostScreen
import cd.wayupdev.mzr.ui.screen.auth.AuthScreen
import cd.wayupdev.mzr.ui.screen.detailPost.DetailPost
import cd.wayupdev.mzr.ui.screen.favory.FavoriteScreen
import cd.wayupdev.mzr.ui.screen.home.HomeScreen
import cd.wayupdev.mzr.ui.screen.settings.SettingScreen
import cd.wayupdev.mzr.ui.screen.splash.SplashScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun MainNavGraph(navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.About.route){
            AboutScreen(navController)
        }

        composable(Screen.Settings.route){
            SettingScreen(navController)
        }

        composable(Screen.Auth.route){
            AuthScreen(navController)
        }

        composable(Screen.AddPost.route){
            AddPostScreen(navController)
        }

        composable(Screen.Favorite.route){
            FavoriteScreen(navController)
        }

        composable(Screen.DetailPost.route){
            DetailPost()
        }
    }
}