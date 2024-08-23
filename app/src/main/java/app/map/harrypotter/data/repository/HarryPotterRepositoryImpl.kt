package app.map.harrypotter.data.repository

import app.map.harrypotter.data.remote.api.HarryPotterApi
import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.common.makeSafeRequest
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.repository.HarryPotterRepository
import javax.inject.Inject

class HarryPotterRepositoryImpl @Inject constructor(
    private val harryPotterApi: HarryPotterApi
): HarryPotterRepository {
    override suspend fun getAllCharacters(): Result<List<CharactersItem?>> {
        return makeSafeRequest {
            harryPotterApi.getAllCharacters()
        }
    }
}