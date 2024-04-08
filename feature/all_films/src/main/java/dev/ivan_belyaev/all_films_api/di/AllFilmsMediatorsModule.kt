package dev.ivan_belyaev.all_films_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.all_films_api.AllFilmsMediator
import dev.ivan_belyaev.core.navigation.MediatorsMap
import dev.ivan_belyaev.core.navigation.getMediator

@Module
object AllFilmsMediatorsModule {

    @Provides
    fun provideAllFilmsMediator(
        mediatorsMap: MediatorsMap
    ): AllFilmsMediator {
        return mediatorsMap.getMediator()
    }
}