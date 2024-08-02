package app.map.harrypotter.presentation.navgraph

sealed class Route(
    val route: String
) {
    object IntroScreen: Route(route = "introScreen")
    object HomeScreen: Route(route = "homeScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
}