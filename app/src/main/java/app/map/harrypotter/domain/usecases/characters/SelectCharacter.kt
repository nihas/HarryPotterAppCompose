package app.map.harrypotter.domain.usecases.characters

import app.map.harrypotter.domain.common.Result
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.repository.HarryPotterRepository
import javax.inject.Inject

class SelectCharacter @Inject constructor(
    private val harryPotterRepository: HarryPotterRepository
) {
    suspend  operator fun invoke(value: Int): Result<List<CharactersItem?>> {
        return  when(value){
            0 -> harryPotterRepository.getAllCharacters()
            1 -> harryPotterRepository.getStudents()
            2 -> harryPotterRepository.getStaffs()
            3 -> harryPotterRepository.getHouses()
            else -> harryPotterRepository.getAllCharacters()
        }
    }
}