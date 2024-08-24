package app.map.harrypotter.presentation.list

sealed class ListScreenEvent {
    object AllCharacters: ListScreenEvent()
    object Students: ListScreenEvent()
    object Staffs: ListScreenEvent()
    object Houses: ListScreenEvent()
    object Spells: ListScreenEvent()
}