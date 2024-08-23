package app.map.harrypotter.presentation.home

import app.map.harrypotter.domain.model.CharactersItem

data class HomeState(
    val isLoading: Boolean = false,
    val characters: List<CharactersItem?>? = emptyList(),
    val error: Exception? = null,
)