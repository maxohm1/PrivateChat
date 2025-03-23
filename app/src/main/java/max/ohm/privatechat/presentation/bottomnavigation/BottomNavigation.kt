package max.ohm.privatechat.presentation.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import max.ohm.privatechat.R

@Composable

fun BottomNavigation(
    navHostController: NavHostController,
    onClick: (index: Int) -> Unit,
    selectedItem: Int
) {

 val items = listOf(
     NavigationItem("Chats", R.drawable.chat_icon, R.drawable.outline_chat_24),
     NavigationItem("Updates", R.drawable.update_icon, R.drawable.update_icon),
     NavigationItem("Communities", R.drawable.baseline_groups_24, R.drawable.outline_chat_24),
     NavigationItem("Calls", R.drawable.telephone, R.drawable.outline_chat_24)

 )

    NavigationBar(containerColor = Color.White, modifier = Modifier.height(80.dp)) {

        items.forEachIndexed{ index, item ->
          NavigationBarItem(
              selected = selectedItem == index,
              onClick = { onClick(index) },
              label = {
                  if(index == selectedItem){
                      Text(item.name, color = Color.Black)
                  }else{
                      Text(item.name, color = Color.DarkGray)

                  }
              },
              icon = {
                  Icon(
                      painter= if(
                          index == selectedItem
                      ){
                          painterResource(id = item.selectedIcon)
                      }else{
                          painterResource(id = item.unSelectedIcon)
                      }, contentDescription = null,
                      tint = if (index == selectedItem){
                          Color.DarkGray
                      }else{
                          Color.Black
                      },
                      modifier = Modifier.size(24.dp)
                  )
                  Spacer(modifier = Modifier.width(4.dp))
              },
              colors = NavigationBarItemDefaults.colors(indicatorColor = colorResource(R.color.mint_green))




          )
        }



    }
}

data class NavigationItem(
    val name: String,
    @DrawableRes val selectedIcon : Int,
    @DrawableRes val unSelectedIcon : Int
)