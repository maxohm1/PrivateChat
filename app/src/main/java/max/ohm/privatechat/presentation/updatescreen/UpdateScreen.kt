package max.ohm.privatechat.presentation.updatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.channels.Channel
import max.ohm.privatechat.R
import max.ohm.privatechat.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)

fun UpdateScreen() {

    val scrollState = rememberScrollState()
    val sampleStatus = listOf(
        StatusData(R.drawable.carryminati, "Carry Minati", "7 minutes ago" ),
        StatusData(R.drawable.tripti_dimri, "tripti dimri", "10 minutes ago" ),
        StatusData(R.drawable.sharadha_kapoor, "Sharadha Kapoor", "20 minutes ago" ),
        StatusData(R.drawable.disha_patani, "Disha Patani", "50 minutes ago" ),


    )

 val sampleChannel= listOf(
     Channels(R.drawable.img, "Bitmap", "Creates your unique ideas"),
     Channels(R.drawable.girl, "Meta", "Live in Virtual Reality"),
     Channels(R.drawable.girl2, "Prachi", "Shooting Movie"),
 )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = colorResource(id= R.color.light_green),
                modifier= Modifier.size(65.dp),
                contentColor = Color.White

            ) {
                Icon(painter = painterResource(id= R.drawable.baseline_photo_camera_24), contentDescription = null,)
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        topBar = {
            TopBar()
        }

    ) {

        Column(modifier= Modifier.padding(it).
        fillMaxSize().verticalScroll(scrollState)) {

            Text(text = "Status", fontSize = 20.sp,
               fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier= Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )

            MyStatus()

             // not use lazyColumn because it give also scrollable it conflict with column vertical scroll
             sampleStatus.forEach{
                 StatusItem(statusData = it)
             }

            Spacer(modifier= Modifier.height(16.dp))
            HorizontalDivider(
                color = Color.Gray
            )

            Text(text = "Channels",
               fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color= Color.Black,
                modifier= Modifier.padding(horizontal = 12.dp, vertical = 8.dp)

                )

            Spacer(modifier= Modifier.height(8.dp))

            Column(modifier= Modifier.padding(horizontal = 16.dp)) {
                Text(text = "stay updated on topics that matter to you. Find channels to follow below")

                Spacer(modifier= Modifier.height(32.dp))
                Text(text= "Find channels to follow")
            }

            Spacer(modifier= Modifier.height(16.dp))

            sampleChannel.forEach{

                ChannelItemDesign(channels = it)
            }

        }

    }
}