package app.map.harrypotter.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import app.map.harrypotter.presentation.home.HomeViewModel
import app.map.harrypotter.presentation.home.Homescreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = "",
            startDestination = ""
        ){
            composable(route = ""){
                val viewModel: HomeViewModel =  hiltViewModel()
                Homescreen()
            }
        }
    }
}