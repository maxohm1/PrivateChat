package max.ohm.privatechat.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import max.ohm.privatechat.presentation.callscreen.CallItemDesign
import max.ohm.privatechat.presentation.callscreen.CallScreen
import max.ohm.privatechat.presentation.communitiesscreen.CommunitiesScreen
import max.ohm.privatechat.presentation.homescreen.HomeScreen
import max.ohm.privatechat.presentation.splashscreen.SplashScreen
import max.ohm.privatechat.presentation.updatescreen.UpdateScreen
import max.ohm.privatechat.presentation.userregistrationscreen.UserRegistrationScren
import max.ohm.privatechat.presentation.welcomescreen.WelcomeScreen


@Composable

fun WhatsAppNavigationSystem() {


    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController= navController){

        // navGraph- which routes screen go

        composable<Routes.SplashScreen>{
            SplashScreen(navController)
        }

        composable<Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }

        composable<Routes.UserRegistrationScreen>{
            UserRegistrationScren()
        }
        composable<Routes.HomeScreen>{
            HomeScreen()
        }
        composable<Routes.UpdateScreen>{
            UpdateScreen()
        }
        composable<Routes.CommunitiesScreen>{
            CommunitiesScreen()
        }
        composable<Routes.CallScreen>{
            CallScreen()
        }

    }
}