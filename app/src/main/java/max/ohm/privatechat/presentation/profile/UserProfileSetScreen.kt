package max.ohm.privatechat.presentation.profile


import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import max.ohm.privatechat.presentation.viewmodel.PhoneAuthViewModel
import max.ohm.privatechat.R
import max.ohm.privatechat.presentation.navigation.Routes

@Composable
fun UserProfileSetScreen(phoneAuthViewModel: PhoneAuthViewModel= hiltViewModel(),
                         navHostController: NavHostController) {

    var name by remember{mutableStateOf("")}
    var status by remember { mutableStateOf("") }
    var profileImageUri by remember{mutableStateOf<Uri?>(null)}
    var bitmapImage by remember { mutableStateOf<Bitmap?>(null) }

    var firebaseAuth = Firebase.auth
    val phoneNumber = firebaseAuth.currentUser?. phoneNumber?:""
    val userId = firebaseAuth.currentUser?.uid ?: ""

    val context = LocalContext.current
    val imagePickerLauncher= rememberLauncherForActivityResult(
        contract =  ActivityResultContracts.GetContent(),
        onResult = { uri:Uri? ->

            profileImageUri= uri

            uri?.let {

                bitmapImage = if (Build.VERSION.SDK_INT < 28){

                    @Suppress( "DEPRECATION")
                    android.provider.MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                } else{
                    // for android 9 or below (method to get image)

                    val source = ImageDecoder.createSource(context.contentResolver, it)
                    ImageDecoder.decodeBitmap(source)
                }
            }

        }


    )

    Column(
        modifier= Modifier.padding(16.dp)
            .fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Box(modifier = Modifier.size(128.dp).clip(CircleShape)
            .border(2.dp, color = colorResource(R.color.teal_200),
                shape = CircleShape )
            .clickable{ imagePickerLauncher.launch("image/*")}) {

            if(bitmapImage!= null){
                Image(
                    // null safety byPass
                    bitmap = bitmapImage!!.asImageBitmap(),
                    contentDescription = null,
                    modifier= Modifier.fillMaxSize().clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

            }else if(profileImageUri != null){
                Image(
                    // coil- show the image in application
                    painter = rememberImagePainter(profileImageUri),
                    contentDescription = null,
                    modifier= Modifier.fillMaxSize().clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

            }

            else{

                 Image(
                     painter = painterResource(R.drawable.user_profile),
                     contentDescription = null,
                     modifier = Modifier.fillMaxSize()
                         .align(Alignment.Center)

                     )

            }

        }
        Spacer(modifier= Modifier.height(16.dp))

        Text(phoneNumber)

        Spacer(modifier= Modifier.height(16.dp))

       TextField(
           value = name,
           onValueChange = {name= it},
           label = {Text("Name")},
           modifier=Modifier.fillMaxWidth(),
           colors = TextFieldDefaults.colors(
               focusedTextColor = colorResource(id = R.color.black),
               focusedContainerColor = colorResource(id = R.color.white),
               unfocusedIndicatorColor = colorResource(id = R.color.light_green),

           )
       )

        Spacer(modifier= Modifier.height(16.dp))

        TextField(
            value = status,
            onValueChange = {status= it},
            label = {Text("Status")},
            modifier=Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = colorResource(id = R.color.black),
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedIndicatorColor = colorResource(id = R.color.light_green),

                )
        )

        Spacer(modifier= Modifier.height(32.dp))

        Button(
            onClick = {
                phoneAuthViewModel.savedUserProfile(userId,name, status, bitmapImage)
                navHostController.navigate(Routes.HomeScreen)

            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.light_green))

        ) {
            Text("Save")
        }


    }



}