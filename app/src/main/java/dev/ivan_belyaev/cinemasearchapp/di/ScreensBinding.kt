package dev.ivan_belyaev.cinemasearchapp.di

import dagger.Module
import dev.ivan_belyaev.all_films_api.di.AllFilmsMediatorModule
import dev.ivan_belyaev.film_by_id.di.FilmByIdMediatorModule

@Module(
    includes = [
        FilmByIdMediatorModule::class,
        AllFilmsMediatorModule::class,
    ]
)
internal interface ScreensBinding