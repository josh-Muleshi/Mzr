package cd.wayupdev.mzr.ui.screen.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.R
import cd.wayupdev.mzr.app.navigation.Screen
import cd.wayupdev.mzr.ui.screen.about.business.AboutState
import cd.wayupdev.mzr.ui.screen.about.business.AboutViewModel
import cd.wayupdev.mzr.ui.screen.topAppBar.AppBarScreen

@Composable
fun AboutScreen(navController: NavHostController,aboutViewModel: AboutViewModel = hiltViewModel()) {

    val state by aboutViewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            AppBarScreen(navController,ScreenName = "About us")
        }
    ){
        Text(text = "About us", modifier = Modifier.padding(16.dp), color = Color.Black)

        IconButton(onClick = {
            when(state) {
                is AboutState.Success -> {
                    if ((state as AboutState.Success).isAuth) {
                        navController.navigate(Screen.AddPost.route)
                    } else {
                        navController.navigate(Screen.Auth.route)
                    }
                }
                is AboutState.Error -> {
                    //snackbarHostState.showSnackbar((state as AboutState.Error).errorMessage)
                    println((state as AboutState.Error).errorMessage)
                }
                else -> {}
            }

        }) {
            Icon(
                painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = ""
            )
        }
    }
}


