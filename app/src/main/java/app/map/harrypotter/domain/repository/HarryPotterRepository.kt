package app.map.harrypotter.domain.repository

import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.model.CharactersItem

interface HarryPotterRepository {

    suspend fun getAllCharacters(): Result<List<CharactersItem?>>
    suspend fun getStudents(): Result<List<CharactersItem?>>
    suspend fun getStaffs(): Result<List<CharactersItem?>>
    suspend fun getSelectedCharacter(selectedChar: Int): Result<List<CharactersItem?>>
}