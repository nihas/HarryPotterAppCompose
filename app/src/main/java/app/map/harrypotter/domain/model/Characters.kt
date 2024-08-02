package app.map.harrypotter.domain.model

import com.google.gson.annotations.SerializedName

data class Characters(
	val characters: List<CharactersItem?>? = null
)

data class CharactersItem(
	val patronus: String? = null,
	val hogwartsStudent: Boolean? = null,
	val image: String? = null,
	val ancestry: String? = null,
	val gender: String? = null,
	val alive: Boolean? = null,
	val hairColour: String? = null,
	val dateOfBirth: String? = null,
	val house: String? = null,
	val hogwartsStaff: Boolean? = null,
	@SerializedName("alternate_names") val alternateNames: List<String?>? = null,
	val actor: String? = null,
	@SerializedName("alternate_actors") val alternateActors: List<Any?>? = null,
	val species: String? = null,
	val wand: Wand? = null,
	val name: String? = null,
	val wizard: Boolean? = null,
	val eyeColour: String? = null,
	val id: String? = null,
	val yearOfBirth: Int? = null
)

data class Wand(
	val core: String? = null,
	val length: Int? = null,
	val wood: String? = null
)

