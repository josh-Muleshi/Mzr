package cd.wayupdev.mzr.ui.screen.addpost

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.wayupdev.mzr.R
import cd.wayupdev.mzr.app.navigation.Screen
import cd.wayupdev.mzr.ui.screen.topAppBar.AppBarScreen
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AddPostScreen(navController : NavHostController) {
    Column {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .width(120.dp)) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigate(Screen.Home.route) }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close", modifier = Modifier.size(30.dp))
                }
                Button(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ),
                    shape = RoundedCornerShape(corner = CornerSize(12.dp)),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Save")
                }
            }
        }
        
        

        RequestContentPermission()
    }

}

@Composable
fun CuatomTextField() {
    
}

@Composable
fun RequestContentPermission() {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    /*val context = LocalContext.current
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }*/
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
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
            GlideImage(imageModel = imageUri, contentScale = ContentScale.Crop, modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(shape = RoundedCornerShape(corner = CornerSize(10.dp)),onClick = {
            launcher.launch("image/*")
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_photo_camera),
                contentDescription = null,
                modifier = Modifier.padding(25.dp)
            )
        }

    }
}