package app.map.harrypotter.domain.repository

import app.map.harrypotter.domain.model.Characters
import app.map.harrypotter.domain.model.CharactersItem
import kotlinx.coroutines.flow.Flow

interface HarryPotterRepository {

    suspend fun getAllCharacters(): Flow<Characters>
}