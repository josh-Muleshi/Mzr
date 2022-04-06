package cd.wayupdev.mzr.ui.screen.addpost

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.R
import cd.wayupdev.mzr.app.navigation.Screen
import cd.wayupdev.mzr.ui.screen.addpost.business.AddPostViewModel
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun AddPostScreen(navController : NavHostController) {
    AddPost(navController = navController)
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun AddPost(navController: NavHostController?, viewModel: AddPostViewModel = hiltViewModel()){

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
                    navController?.navigate(Screen.Home.route)
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close", modifier = Modifier.size(30.dp))
                }
                Button(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ),
                    shape = RoundedCornerShape(corner = CornerSize(12.dp)),
                    onClick = { }
                ) {
                    Text(text = "Save")
                }
            }
        }
        CustomTextField(onSubmit = {
                name, desc, uri ->  viewModel.addPost(name, desc, uri)
        })
    }
}

@Composable
fun CustomTextField( onSubmit: (name :String, desc: String, uri: Uri) -> Unit = {_,_,_ -> }) {

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var value by remember { mutableStateOf("") }
    val focusRequest = remember {
        FocusRequester()
    }

    LaunchedEffect(Unit){
        focusRequest.requestFocus()
    }

    var textFieldHeight by remember {
        mutableStateOf(190.dp)
    }

    if (imageUri != null) {
        textFieldHeight = Dp.Unspecified
    } else {
        190.dp
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = { Text("Enter text") },
            textStyle = TextStyle(fontSize = MaterialTheme.typography.subtitle1.fontSize),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .focusRequester(focusRequest)
                .defaultMinSize(minHeight = textFieldHeight),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = MaterialTheme.colors.background,
                unfocusedIndicatorColor = MaterialTheme.colors.background
            )
        )

        /*val context = LocalContext.current
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }*/
        val launcher = rememberLauncherForActivityResult(
            contract =
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            imageUri = uri
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            /*imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver,it)

            } else {
                val source = ImageDecoder
                    .createSource(context.contentResolver,it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let {  btm ->
                Image(bitmap = btm.asImageBitmap(),
                    contentDescription =null,
                    modifier = Modifier.size(400.dp))
            }
        }*/
            if (imageUri != null) {
                GlideImage(
                    imageModel = imageUri,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(300.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Button(shape = RoundedCornerShape(corner = CornerSize(10.dp)), onClick = {
                launcher.launch("image/*")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_photo_camera),
                    contentDescription = null,
                    modifier = Modifier.padding(25.dp)
                )
            }
        }

        Button(
            enabled = value.isNotEmpty(),
            onClick = { imageUri?.let { onSubmit.invoke("josh", value, it) } },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red, contentColor = Color.White)
        ) {
            Text(text = "Enregistrer" )
        }

    }
}