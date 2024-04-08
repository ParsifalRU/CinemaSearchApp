package dev.ivan_belyaev.film_by_id.di

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.film_by_id.data.FilmByIdRepositoryImpl
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository

@Module
interface FilmByIdRepositoryModule {

    @Binds
    fun provideFilmByIdRepository(repository: FilmByIdRepositoryImpl): FilmByIdRepository
}

