package app.map.harrypotter.presentation.home

import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.model.SpellsItem

data class HomeState(
    val isLoading: Boolean = false,
    val characters: List<CharactersItem?>? = emptyList(),
    val spells: List<SpellsItem?>? = emptyList(),
    val error: Exception? = null,
)