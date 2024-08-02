package app.map.harrypotter.presentation.navgraph

sealed class Route(
    val route: String
) {
    object IntroScreen: Route(route = "introScreen")
    object HomeScreen: Route(route = "homeScreen")
    object HomeNavigatorScreen: Route(route = "homeNavigator")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object HarryPotterNavigation: Route(route = "harryPotterNavigation")
}