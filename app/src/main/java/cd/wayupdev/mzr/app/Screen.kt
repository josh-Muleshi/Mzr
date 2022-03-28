package cd.wayupdev.mzr.app

sealed class Screen (val route : String){
    object Auth : Screen("auth")
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Post : Screen("post")
    object AddPost : Screen("add-post")
    object About : Screen("about-us")
    object Settings : Screen("settings")
    object Share : Screen("share")
    object Favorite : Screen("favorite")
}
