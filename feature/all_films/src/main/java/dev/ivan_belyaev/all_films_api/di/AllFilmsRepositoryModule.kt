package dev.ivan_belyaev.all_films_api.di

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.all_films_api.data.FilmByNameRepositoryImpl
import dev.ivan_belyaev.all_films_api.data.FilmWithFiltersRepositoryImpl
import dev.ivan_belyaev.all_films_api.domain.FilmByNameRepository
import dev.ivan_belyaev.all_films_api.domain.FilmWithFiltersRepository

@Module
interface AllFilmsRepositoryModule {

    @Binds
    fun provideFilmByNameRepository(repository: FilmByNameRepositoryImpl): FilmByNameRepository

    @Binds
    fun provideFilmWithFiltersRepository(repository: FilmWithFiltersRepositoryImpl): FilmWithFiltersRepository
}