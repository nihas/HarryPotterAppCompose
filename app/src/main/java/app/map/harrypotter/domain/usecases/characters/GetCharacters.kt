package app.map.harrypotter.domain.usecases.characters

import androidx.paging.PagingData
import app.map.harrypotter.domain.model.Characters
import app.map.harrypotter.domain.repository.HarryPotterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val harryPotterRepository: HarryPotterRepository
) {
    suspend operator fun invoke(sources: List<String>): Flow<Characters> {
        return harryPotterRepository.getAllCharacters()
    }
}