package app.map.harrypotter.domain.usecases.characters

data class HarryPotterUseCases(
    val getCharacters: GetCharacters,
    val getStudents: GetStudents,
    val getSttafs: GetStaffs,
    val selectArticle: SelectCharacter,
)