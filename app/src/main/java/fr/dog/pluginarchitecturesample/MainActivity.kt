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
import fr.dog.pluginarchitecturesample.cat.catModule
import fr.dog.pluginarchitecturesample.data.Animal
import fr.dog.pluginarchitecturesample.dog.dogModule
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getKoin

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
    val detail = NavigationContract.Detail { animalType ->
        setupDetailModuleWith(animalType)

        get()
    }
    val home = NavigationContract.Home { animalType ->
        navController.navigate(NavigationContract.Detail.asDirection(animalType))
    }

    NavHost(navController = navController, startDestination = home.route) {
        addDestination(home)
        addDestination(detail)
    }
}

@Composable
private fun setupDetailModuleWith(animalType: Animal.AnimalType) {
    getKoin().loadModules(modules = listOf(detailModuleFor(animalType)), allowOverride = true)
}

private fun detailModuleFor(animalType: Animal.AnimalType) = when(animalType) {
    Animal.AnimalType.DOG -> dogModule
    Animal.AnimalType.CAT -> catModule
}

private fun NavGraphBuilder.addDestination(
    navigationContract: NavigationContract,
) = composable(
    route = navigationContract.route,
    arguments = navigationContract.arguments
) { backStackEntry ->
    navigationContract.content(backStackEntry)
}