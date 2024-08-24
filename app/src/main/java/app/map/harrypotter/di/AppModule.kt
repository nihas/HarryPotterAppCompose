package app.map.harrypotter.di

import app.map.harrypotter.data.remote.api.HarryPotterApi
import app.map.harrypotter.domain.repository.HarryPotterRepository
import app.map.harrypotter.domain.usecases.characters.GetCharacters
import app.map.harrypotter.domain.usecases.characters.GetStaffs
import app.map.harrypotter.domain.usecases.characters.GetStudents
import app.map.harrypotter.domain.usecases.characters.HarryPotterUseCases
import app.map.harrypotter.domain.usecases.characters.SelectCharacter
import app.map.harrypotter.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiInstance(): HarryPotterApi{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterApi::class.java)
    }

    fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Set log level as needed
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesHarryPotterUseCases(
        harryPotterRepository: HarryPotterRepository
    ): HarryPotterUseCases{
        return HarryPotterUseCases(
            getCharacters = GetCharacters(harryPotterRepository),
            selectArticle = SelectCharacter(harryPotterRepository),
            getStudents = GetStudents(harryPotterRepository),
            getSttafs = GetStaffs(harryPotterRepository)
        )
    }
}