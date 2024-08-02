package app.map.harrypotter.domain.model

data class Spells(
	val spells: List<SpellsItem?>? = null
)

data class SpellsItem(
	val name: String? = null,
	val description: String? = null,
	val id: String? = null
)

