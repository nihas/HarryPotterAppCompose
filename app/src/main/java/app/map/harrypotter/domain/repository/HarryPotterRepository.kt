package app.map.harrypotter.domain.repository

import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.model.SpellsItem

interface HarryPotterRepository {

    suspend fun getAllCharacters(): Result<List<CharactersItem?>>
    suspend fun getStudents(): Result<List<CharactersItem?>>
    suspend fun getStaffs(): Result<List<CharactersItem?>>
    suspend fun getHouses(): Result<List<CharactersItem?>>
    suspend fun getSpells(): Result<List<SpellsItem?>>
}