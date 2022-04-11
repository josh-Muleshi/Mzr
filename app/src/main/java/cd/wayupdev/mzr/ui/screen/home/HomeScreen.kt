package cd.wayupdev.mzr.ui.screen.home

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.app.navigation.Screen
import cd.wayupdev.mzr.data.ShowList
import cd.wayupdev.mzr.data.model.Post
import cd.wayupdev.mzr.ui.screen.home.business.HomeState
import cd.wayupdev.mzr.ui.screen.home.business.HomeViewModel
import cd.wayupdev.mzr.ui.screen.home.componant.TopPageBar
import cd.wayupdev.mzr.ui.theme.Black_ic

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val posts by viewModel.data.collectAsState()


    BackHandler(enabled = true) {
        (context as? Activity)?.finish()
    }
    Scaffold(
        topBar = {
            TopPageBar(navController)
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.Favorite.route)},
                backgroundColor = MaterialTheme.colors.primary) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            DisplayItShow((posts as HomeState.Success).posts){
                navController.navigate(Screen.DetailPost.route)
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun DisplayItShow(posts: ArrayList<Post>, selectedItem: (Post)->(Unit)) {
    //val itShow = remember { ShowList.itShows }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
    ){
        items(
            items = posts,
            itemContent = {
                ItemUi(post = it, selectedItem = selectedItem)
            }
        )
    }
}

@Composable
fun ItemUi(post: Post, selectedItem: (Post)->(Unit)) {
    Card(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { selectedItem(post) },
            verticalArrangement = Arrangement.Center
        ) {

            ItemShowImage(post = post)

            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(text = post.title, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = post.description,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/*--------*/

@Composable
fun ItemShowImage(post: Post) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = post.imageUrl.toInt()),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        )
        BottomShadow(post)
    }
}

@Composable
fun BottomShadow(post: Post) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Black_ic
                    )
                )
            )
            .height(80.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
                    .background(color = Color.White)
                    .padding(start = 8.dp, end = 8.dp)
            ){
                Row {
                    Image(painterResource(id = cd.wayupdev.mzr.R.drawable.ic_date), contentDescription = "date")
                    Text(
                        text = "14 fev 2022",
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}




