package fr.dog.pluginarchitecturesample

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fr.dog.detail.DetailScreen

sealed class NavigationContracts(val route: String, private val screenFactory: @Composable () -> Unit) {
    object Home : NavigationContracts(route = "home", screenFactory = { HomeScreen() })
    object Detail : NavigationContracts(route = "detail", screenFactory = { DetailScreen() })

    fun addDestinationTo(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(route) {
            screenFactory.invoke()
        }
    }
}