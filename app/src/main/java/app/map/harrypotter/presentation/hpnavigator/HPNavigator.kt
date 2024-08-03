package app.map.harrypotter.presentation.hpnavigator

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.map.harrypotter.presentation.home.HomeScreen
import app.map.harrypotter.presentation.home.HomeViewModel
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
            composable(route = Route.HomeScreen.route) { backStackEntry ->
                val viewModel: HomeViewModel = hiltViewModel()
//            val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen()
            }
//        composable(route = Route.SearchScreen.route) {
//            val viewModel: SearchViewModel = hiltViewModel()
//            val state = viewModel.state.value
//            OnBackClickStateSaver(navController = navController)
//            SearchScreen(
//                state = state,
//                event = viewModel::onEvent,
//                navigateToDetails = { article ->
//                    navigateToDetails(
//                        navController = navController,
//                        article = article
//                    )
//                }
//            )
//        }
//        composable(route = Route.DetailsScreen.route) {
//            val viewModel: DetailsViewModel = hiltViewModel()
//            navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
//                ?.let { article ->
//                    DetailsScreen(
//                        article = article,
//                        event = viewModel::onEvent,
//                        navigateUp = { navController.navigateUp() },
//                        sideEffect = viewModel.sideEffect
//                    )
//                }
//
//        }
//        composable(route = Route.BookmarkScreen.route) {
//            val viewModel: BookmarkViewModel = hiltViewModel()
//            val state = viewModel.state.value
//            OnBackClickStateSaver(navController = navController)
//            BookmarkScreen(
//                state = state,
//                navigateToDetails = { article ->
//                    navigateToDetails(
//                        navController = navController,
//                        article = article
//                    )
//                }
//            )
//        }
        }
    }

}