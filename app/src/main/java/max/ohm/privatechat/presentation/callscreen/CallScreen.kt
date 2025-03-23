package max.ohm.privatechat.presentation.callscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import max.ohm.privatechat.R
import max.ohm.privatechat.presentation.bottomnavigation.BottomNavigation
import max.ohm.privatechat.presentation.navigation.Routes

@Composable


fun CallScreen(navHostController: NavHostController) {

    val sampleCall = listOf(
        Call(R.drawable.bhuvan_bam, "Bhuvam Bam", "Yesterday, 2:46 PM", true),
        Call(R.drawable.hrithik_roshan, "Hrithik Roshan", "Today, 2:45 PM", true),
        Call(R.drawable.disha_patani, "Disha Patani", "Now 5:34 PM", false),
        Call(R.drawable.girl, "Stacey", "Tuesday, 4:53 AM", false),
        Call(R.drawable.sharadha_kapoor, "Sharadha Kapoor", "Monday, 2:35 PM", true),
        Call(R.drawable.akshay_kumar, "Akshay Kumar", "now", false)
    )


    var isSeaching by remember {
        mutableStateOf(false)
    }

    var search by remember {
        mutableStateOf("")
    }

    var showMenu by remember{
        mutableStateOf(false)
    }


    Scaffold (

        topBar= {


            Box(modifier= Modifier.fillMaxWidth()){

                Column {

                    Row {

                        if(isSeaching){

                            TextField(value = search, onValueChange = {search= it},
                                placeholder = { Text("Search")},
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ), modifier= Modifier.padding(start= 12.dp), singleLine = true)
                        } else {

                            Text(
                                text= "Calls",
                                fontSize = 28.sp,
                                color = Color.Black,
                                modifier= Modifier.padding(start= 12.dp, top= 4.dp)

                            )
                        }

                        Spacer(modifier= Modifier.weight(1f))
                        if(isSeaching){

                            IconButton(onClick = {isSeaching= false

                                // after clicking cross button seach will be empty
                                search =""
                            }) {

                                Icon(painter = painterResource(id = R.drawable.cross),
                                    contentDescription = null,
                                    modifier= Modifier.size( 14.dp)
                                )
                            }
                        }  else {

                            IconButton(onClick = { isSeaching= true}) {

                                Icon(painter= painterResource(id= R.drawable.search),
                                    contentDescription = null,
                                    modifier= Modifier.size(24.dp)
                                )
                            }

                            IconButton(onClick = {
                                showMenu= true
                            })
                            {

                                Icon(painter= painterResource(id= R.drawable.more),
                                    contentDescription = null,
                                    modifier= Modifier.size(24.dp)
                                )

                                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {

                                    DropdownMenuItem(text = {Text(text = "Settings")},
                                        onClick = { showMenu= false})
                                }
                            }

                        }
                    }
                    HorizontalDivider()
                }
            }
        }, bottomBar = {
            BottomNavigation(navHostController, selectedItem = 0, onClick = {index ->
                when(index){

                    0 -> {navHostController.navigate(Routes.HomeScreen)}
                    1 -> {navHostController.navigate(Routes.UpdateScreen)}
                    2 -> {navHostController.navigate(Routes.CommunitiesScreen)}
                    3 -> {navHostController.navigate(Routes.CallScreen)}
                }

            })
        },
          floatingActionButton = {
              FloatingActionButton(
                  onClick = { },
                  containerColor = colorResource(id= R.color.light_green),
                  modifier= Modifier.size(65.dp),
                  contentColor = Color.White

              ) {
                  Icon(painter = painterResource(id= R.drawable.add_call), contentDescription = null,)
              }
          }
        )

    {
        Column(modifier= Modifier.padding(it)) {
           Spacer(modifier= Modifier.height(15.dp))
             FavoritesSection()

            Button(onClick = {},
                modifier=Modifier.fillMaxWidth().
                padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.light_green)
                )
                ) {

                Text("Start a new call", fontSize = 16.sp, fontWeight = FontWeight.Bold)


            }
            Spacer(modifier= Modifier.height(8.dp))
            Text("Recent Calls", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier= Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn {


                // this is making confusing adready define it
//                items(sampleCall){
//                    CallItemDesign(Call = it)
//
//                }
            

                // explicit data
                items(sampleCall){
                    data->
                    CallItemDesign(data)
                }





            }



        }
    }
}