package fr.dog.pluginarchitecturesample

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import fr.dog.detail.DefaultDetailConfiguration
import fr.dog.detail.DetailScreen

sealed class NavigationContract {
    abstract val route: String

    @Composable
    abstract fun content(backStackEntry: NavBackStackEntry)

    open val arguments: List<NamedNavArgument> = emptyList()

    class Home(
        private val goToDetail: (Animal.AnimalType) -> Unit
    ) : NavigationContract() {
        override val route = "home"

        @Composable
        override fun content(backStackEntry: NavBackStackEntry) {
            HomeScreen(goToDetail = goToDetail)
        }
    }

    object Detail : NavigationContract() {
        private const val ANIMAL_TYPE = "ANIMAL_TYPE"

        override val route = "detail/{$ANIMAL_TYPE}"

        override val arguments = listOf(
            navArgument(ANIMAL_TYPE) { type = NavType.StringType }
        )

        fun asDirection(animalType: Animal.AnimalType) = route.replace(ANIMAL_TYPE, animalType.name)

        @Composable
        override fun content(backStackEntry: NavBackStackEntry) {
            val arguments =
                backStackEntry.arguments ?: throw IllegalArgumentException("No arguments given")
            val animalType = arguments.getString(ANIMAL_TYPE)

            DetailScreen(detailConfiguration = DefaultDetailConfiguration)
        }
    }
}