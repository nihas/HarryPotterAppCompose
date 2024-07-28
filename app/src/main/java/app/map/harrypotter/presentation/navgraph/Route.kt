package app.map.harrypotter.presentation.navgraph

sealed class Route(
    val route: String
) {
    object HomeScreen: Route(route = "homeScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
}