package app.map.harrypotter.domain.repository

import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.model.CharactersItem

interface HarryPotterRepository {

    suspend fun getAllCharacters(): Result<List<CharactersItem?>>
}