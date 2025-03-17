package max.ohm.privatechat.presentation.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.*
import max.ohm.privatechat.R
import max.ohm.privatechat.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)

fun HomeScreen() {


  val chatData = listOf(
      ChatDesignModel(
       R.drawable.salman_khan,
      name = "Salman Khan",
      time= "10:00 AM",
      message = "Hello om how are you"
      ),

      ChatDesignModel(
          image = R.drawable.sharukh_khan,
          name = "Sharukh Khan",
          time= "12:00 AM",
          message = "chal om ferrari me ghumte hai"
      ),

      ChatDesignModel(
          image = R.drawable.akshay_kumar,
          name = "Akshay Kumar",
          time= "1:00 AM",
          message = "my next movie shooting with you"
      ),
      ChatDesignModel(
          image = R.drawable.disha_patani,
          name = "Disha Patani",
          time= "11:00 PM",
          message = "please mere birthday me aa jana om"
      ),

      ChatDesignModel(
          image = R.drawable.rashmika,
          name = "Rashmika",
          time= "10:44 AM",
          message = "Come back to tollywood om"
      ),
      ChatDesignModel(
          image = R.drawable.rajkummar_rao,
          name = "Rajkumar Rai",
          time= "12:50 AM",
          message = "om,Ek new movie me shooting karoge"
      ),
      ChatDesignModel(
          image = R.drawable.hrithik_roshan,
          name = "Hrithik Roshan",
          time= "5:46 AM",
          message = "Om, you are main hero of krrish 4"
      ),
      ChatDesignModel(
          image = R.drawable.ajay_devgn,
          name = "Ajay Devgan",
          time= "6:00 AM",
          message = "Mumbai aaja teri bhut yaad aa rhi"
      ),

      ChatDesignModel(
          image = R.drawable.bhuvan_bam,
          name = "Bhuvam Bam",
          time= "6:45 AM",
          message = "chal aa ek webseries shooting karte hain"
      ),
      ChatDesignModel(
          image = R.drawable.kartik_aaryan,
          name = "Kartik Aaryan",
          time= "6:36 AM",
          message = "Do you favour on me om "
      )


      )

   // top bar and bottom bar foating bar addeded here
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}, containerColor = colorResource(id = R.color.light_green),
             modifier= Modifier.size(65.dp),
                contentColor = Color.White
                ) {

              Icon(painter = painterResource(id= R.drawable.chat_icon) , contentDescription=null,
                 modifier= Modifier.size(28.dp)
                  )



            }

        },

        bottomBar = {
            BottomNavigation()
        }


    ) {

        Column (modifier= Modifier.padding(it)){
          Spacer(modifier= Modifier.height(16.dp))

            Box(modifier= Modifier.fillMaxWidth()){

                Text(text= "WhatsApp", fontSize = 28.sp, color= colorResource(id= R.color.light_green),
                    modifier = Modifier.align(Alignment.CenterStart).padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                    )

                Row (modifier= Modifier.align(Alignment.CenterEnd)){
                    IconButton(onClick = {}) {

                        Icon(painter = painterResource(id= R.drawable.camera),
                            contentDescription = null,
                            modifier= Modifier.size(24.dp)
                            )
                    }
                    IconButton(onClick = {}) {

                        Icon(painter = painterResource(id= R.drawable.search),
                            contentDescription = null,
                            modifier= Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = {}) {

                        Icon(painter = painterResource(id= R.drawable.more),
                            contentDescription = null,
                            modifier= Modifier.size(24.dp)
                        )
                    }

                }

            }
            HorizontalDivider()

            LazyColumn {

             items(chatData){

                 ChatDesign(chatDesignModel = it )
             }
            }


        }


    }

}