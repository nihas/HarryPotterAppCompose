package app.map.harrypotter.domain.repository

import app.map.harrypotter.domain.model.CharactersItem
import kotlinx.coroutines.flow.Flow

interface HarryPotterRepository {

    fun getAllCharacters(): Flow<List<CharactersItem>>
}