package app.map.harrypotter.data.repository

import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.repository.HarryPotterRepository
import kotlinx.coroutines.flow.Flow

class HarryPotterRepositoryImpl: HarryPotterRepository {
    override fun getAllCharacters(): Flow<List<CharactersItem>> {
        TODO("Not yet implemented")
    }
}