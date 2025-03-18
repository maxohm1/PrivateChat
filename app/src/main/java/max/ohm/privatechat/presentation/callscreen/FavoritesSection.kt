package max.ohm.privatechat.presentation.callscreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import max.ohm.privatechat.R

@Composable
@Preview(showSystemUi = true)
fun FavoritesSection() {


    val sampleFavorites= listOf(
        FavoriteContact(R.drawable.salman_khan, "Salman Khan"),
        FavoriteContact(R.drawable.disha_patani, "Disha Patani"),
        FavoriteContact(R.drawable.hrithik_roshan, "Hrithik Roshan"),
        FavoriteContact(R.drawable.sharadha_kapoor, "Sharadha Kapoor"),
        FavoriteContact(R.drawable.tripti_dimri, "Tripti Dimri"),
        FavoriteContact(R.drawable.akshay_kumar, "Akshay Kumar"),
        FavoriteContact(R.drawable.girl2, "Stacy")

    )

    Column (modifier= Modifier.padding(start= 16.dp, bottom = 8.dp)){

        Text("Favorites", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier= Modifier.padding(bottom = 8.dp
            )
        )

        Row (modifier= Modifier.fillMaxWidth().
        horizontalScroll(rememberScrollState())){

            sampleFavorites.forEach{
               FavoritesItems(favoriteContact = it)
            }


        }
    }
}


data class FavoriteContact(
    val image:Int, val name:String
)