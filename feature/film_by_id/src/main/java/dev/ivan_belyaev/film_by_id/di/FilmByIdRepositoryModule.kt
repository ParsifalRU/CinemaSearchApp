package dev.ivan_belyaev.film_by_id.di

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.film_by_id.data.FilmByIdRepositoryImpl
import dev.ivan_belyaev.film_by_id.data.dto.FilmPostersRepositoryImpl
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import dev.ivan_belyaev.film_by_id.domain.FilmPostersRepository

@Module
interface FilmByIdRepositoryModule {

    @Binds
    fun provideFilmByIdRepository(repository: FilmByIdRepositoryImpl): FilmByIdRepository

    @Binds
    fun provideFilmPostersRepository(repository: FilmPostersRepositoryImpl): FilmPostersRepository
}

