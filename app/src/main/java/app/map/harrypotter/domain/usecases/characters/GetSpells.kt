package app.map.harrypotter.domain.usecases.characters

import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.model.SpellsItem
import app.map.harrypotter.domain.repository.HarryPotterRepository
import javax.inject.Inject

class GetSpells @Inject constructor(
    private val harryPotterRepository: HarryPotterRepository
) {
    suspend operator fun invoke(): Result<List<SpellsItem?>> {
        return harryPotterRepository.getSpells()
    }
}