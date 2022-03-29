package cd.wayupdev.mzr.ui.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    BackHandler(enabled = true) {
        (context as? Activity)?.finish()
    }
    Text(text = "Salut le monde", color = Color.Black, modifier = Modifier.padding(16.dp))
}
