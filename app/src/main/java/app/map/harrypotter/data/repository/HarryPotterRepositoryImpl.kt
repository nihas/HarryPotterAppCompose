package app.map.harrypotter.data.repository

import app.map.harrypotter.data.remote.api.HarryPotterApi
import app.map.harrypotter.domain.model.Characters
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.repository.HarryPotterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HarryPotterRepositoryImpl @Inject constructor(
    private val harryPotterApi: HarryPotterApi
): HarryPotterRepository {
    override suspend fun getAllCharacters(): Flow<Characters> {
        val apiResponse = harryPotterApi.getAllCharacters()
        return apiResponse
    }
}