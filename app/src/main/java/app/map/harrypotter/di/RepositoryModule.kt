package app.map.harrypotter.di

import app.map.harrypotter.data.repository.HarryPotterRepositoryImpl
import app.map.harrypotter.domain.repository.HarryPotterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHarryPotterRepository(
        harryPotterRepositoryImpl: HarryPotterRepositoryImpl
    ): HarryPotterRepository
}