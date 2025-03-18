package max.ohm.privatechat.presentation.communitiesscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import max.ohm.privatechat.R

@Composable
fun CommunityItemDesign(communities: Communities) {

    Row (modifier= Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically){

        Image(painter = painterResource(id= communities.image), contentDescription = null,
            modifier= Modifier.size(60.dp)
            )

        Spacer(modifier= Modifier.width(12.dp))

        Column {

            Text(text = communities.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)

            Text(text =communities.memberCount, fontSize = 14.sp, color = Color.Gray)

        }


    }
    
}


data class Communities(val image:Int , val name:String , val memberCount: String)