package dev.ivan_belyaev.film_by_id.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.core.navigation.MediatorsMap
import dev.ivan_belyaev.core.navigation.getMediator
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator

@Module
object FilmByIdMediatorsModule {

    @Provides
    fun provideFilmByIdMediator(
        mediatorsMap: MediatorsMap
    ): FilmByIdMediator {
        return mediatorsMap.getMediator()
    }
}