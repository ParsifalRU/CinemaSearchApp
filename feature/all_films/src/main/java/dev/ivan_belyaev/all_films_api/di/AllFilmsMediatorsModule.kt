package dev.ivan_belyaev.all_films_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.core.navigation.MediatorsMap
import dev.ivan_belyaev.core.navigation.MediatorsQualifier
import dev.ivan_belyaev.core.navigation.getMediator
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator

@Module
object AllFilmsMediatorsModule {

    @Provides
    fun provideFilmByIdMediator(
        @MediatorsQualifier mediatorsMap: MediatorsMap
    ): FilmByIdMediator {
        return mediatorsMap.getMediator()
    }
}