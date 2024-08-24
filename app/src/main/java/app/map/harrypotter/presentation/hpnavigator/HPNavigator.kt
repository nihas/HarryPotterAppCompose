package app.map.harrypotter.presentation.hpnavigator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.presentation.home.HomeScreen
import app.map.harrypotter.presentation.list.ListScreen
import app.map.harrypotter.presentation.list.ListScreenViewModel
import app.map.harrypotter.presentation.navgraph.Route

@Composable
fun HPNavigator() {
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value

    Scaffold(modifier = Modifier.systemBarsPadding()){
        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.fillMaxSize()
        ) {
            //HomeScreen
            composable(route = Route.HomeScreen.route) { backStackEntry ->
                HomeScreen {
                    navigateToList(navController = navController)
                }
            }
            //ListScreen
            composable(route = Route.ListScreen.route) {
                val viewModel: ListScreenViewModel = hiltViewModel()
                ListScreen(
                    event = viewModel::onEvent,
                    viewModel= viewModel
                )
            }
        }
    }

}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToHome(
            navController = navController
        )
    }
}

private fun navigateToHome(navController: NavController) {
    navController.navigate(
        route = Route.HomeScreen.route
    )
}

private fun navigateToList(navController: NavController, article: CharactersItem? = null) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.ListScreen.route
    )
}