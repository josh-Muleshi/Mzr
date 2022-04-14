package cd.wayupdev.mzr.ui.screen.detailPost

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.R
import cd.wayupdev.mzr.app.navigation.Screen

@Composable
fun DetailPost(navController : NavHostController) {
    Column {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .width(120.dp)) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(Screen.Home.route)
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "close", modifier = Modifier.size(30.dp))
                }

                IconButton(onClick = {
                    navController.navigate(Screen.Favorite.route)
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = "favorite", modifier = Modifier.size(30.dp))
                }
            }
        }
    }
}