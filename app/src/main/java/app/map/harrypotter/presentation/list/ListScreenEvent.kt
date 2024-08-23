package app.map.harrypotter.presentation.list

sealed class ListScreenEvent {
    data class UpdateScrollValue(val newValue: Int): ListScreenEvent()
}