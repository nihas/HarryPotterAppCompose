package app.map.harrypotter.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import app.map.harrypotter.presentation.home.HomeScreen
import app.map.harrypotter.presentation.hpnavigator.HPNavigator
import app.map.harrypotter.presentation.introscreen.IntroScreen
import app.map.harrypotter.presentation.introscreen.IntroViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.IntroScreen.route
        ){
            composable(route = Route.IntroScreen.route){
                val viewModel =  hiltViewModel<IntroViewModel>()
                IntroScreen(viewModel::onEvent)
            }
        }

        navigation(
            route = Route.HomeNavigatorScreen.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route){
                HomeScreen()
            }
        }
    }
}