package dev.ivan_belyaev.cinemasearchapp.di

import dagger.Module
import dev.ivan_belyaev.film_by_id.di.FilmByIdMediatorModule

@Module(
    includes = [
        FilmByIdMediatorModule::class,
    ]
)
internal interface ScreensBinding