package fr.dog.pluginarchitecturesample

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import fr.dog.pluginarchitecturesample.detail.DetailScreen

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

    class Detail(
        private val detailConfigurationFrom: @Composable (Animal.AnimalType) -> DetailConfiguration
    ) : NavigationContract() {
        override val route = ROUTE

        override val arguments = listOf(
            navArgument(ANIMAL_TYPE) { type = NavType.StringType }
        )

        @Composable
        override fun content(backStackEntry: NavBackStackEntry) {
            val arguments = requireNotNull(backStackEntry.arguments)
            val animalType = requireNotNull(arguments.getString(ANIMAL_TYPE))
                .let(Animal.AnimalType::valueOf)

            DetailScreen(detailConfiguration = detailConfigurationFrom(animalType))
        }

        companion object {
            private const val ANIMAL_TYPE = "ANIMAL_TYPE"
            private const val ANIMAL_TYPE_PARAMETER = "{$ANIMAL_TYPE}"
            const val ROUTE = "detail/$ANIMAL_TYPE_PARAMETER"

            fun asDirection(animalType: Animal.AnimalType) = ROUTE.replace(
                ANIMAL_TYPE_PARAMETER,
                animalType.name
            )
        }
    }
}