package app.map.harrypotter.data.remote.api

import app.map.harrypotter.domain.model.Characters
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.domain.model.Spells
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterApi {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharactersItem?>

    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path("id") id: String,
    ): Characters

    @GET("characters/students")
    suspend fun getHogwartsStudents(): List<CharactersItem?>

    @GET("characters/staff")
    suspend fun getHogwartsStaff(): List<CharactersItem?>

    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(
        @Path("house") house: String,
    ): Characters

    @GET("spells")
    suspend fun getAllSpells(): Spells
}