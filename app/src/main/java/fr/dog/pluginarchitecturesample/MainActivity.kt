package fr.dog.pluginarchitecturesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            MainScreen(navHostController)

            lifecycleScope.launch {
                navHostController
                    .currentBackStackEntryFlow
                    .collect { navBackStackEntry ->
                        navBackStackEntry.destination
                    }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationContracts.Home.route) {
        NavigationContracts.Home.addDestinationTo(this)
        NavigationContracts.Detail.addDestinationTo(this)
    }
}