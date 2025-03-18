package max.ohm.privatechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import max.ohm.privatechat.presentation.navigation.WhatsAppNavigationSystem
import max.ohm.privatechat.presentation.splashscreen.SplashScreen
import max.ohm.privatechat.ui.theme.PrivateChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PrivateChatTheme {
                WhatsAppNavigationSystem()
            }
        }
    }
}
