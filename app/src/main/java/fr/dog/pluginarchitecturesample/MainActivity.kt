package fr.dog.pluginarchitecturesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            navController.navigateUp()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            MainScreen(navController)
            onBackPressedDispatcher.addCallback(onBackPressedCallback)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    val detail = NavigationContract.Detail
    val home = NavigationContract.Home { animalType ->
        navController.navigate(detail.asDirection(animalType))
    }

    NavHost(navController = navController, startDestination = home.route) {
        addDestination(home)
        addDestination(detail)
    }
}

private fun NavGraphBuilder.addDestination(
    navigationContract: NavigationContract,
) = composable(
    route = navigationContract.route,
    arguments = navigationContract.arguments
) { backStackEntry ->
    navigationContract.content(backStackEntry)
}