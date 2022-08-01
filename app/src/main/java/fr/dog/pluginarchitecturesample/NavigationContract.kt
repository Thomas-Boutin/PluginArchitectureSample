package fr.dog.pluginarchitecturesample

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import fr.dog.detail.DefaultDetailConfiguration
import fr.dog.detail.DetailScreen

sealed class NavigationContract(val route: String) {
    @Composable
    abstract fun content()

    class Home(
        private val goToDetail: () -> Unit
    ) : NavigationContract(route = "home") {
        @Composable
        override fun content() {
            HomeScreen(goToDetail = goToDetail)
        }
    }

    object Detail : NavigationContract(route = "detail") {
        @Composable
        override fun content() {
            DetailScreen(detailConfiguration = DefaultDetailConfiguration)
        }
    }
}