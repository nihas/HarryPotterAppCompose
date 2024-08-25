package app.map.harrypotter.domain.usecases.characters

data class HarryPotterUseCases(
    val getCharacters: GetCharacters,
    val getStudents: GetStudents,
    val getStaffs: GetStaffs,
    val getSpells: GetSpells,
    val selectCharacters: SelectCharacter,
)