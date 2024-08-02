package app.map.harrypotter.data.remote.api

import app.map.harrypotter.domain.model.Characters
import app.map.harrypotter.domain.model.Spells
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HarryPotterApi {

    @GET("characters")
    suspend fun getAllCharacters(): Flow<Characters>

    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path("id") id: String,
    ): Characters

    @GET("characters/students")
    suspend fun getHogwartsStudents(): Characters

    @GET("characters/staff")
    suspend fun getHogwartsStaff(): Characters

    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(
        @Path("house") house: String,
    ): Characters

    @GET("spells")
    suspend fun getAllSpells(): Spells
}