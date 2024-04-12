package dev.ivan_belyaev.film_by_id.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.core.navigation.MediatorsQualifier
import dev.ivan_belyaev.film_by_id.api.FilmByIdMediatorImpl
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator

@Module
interface FilmByIdMediatorModule {

    @Binds
    fun bindMediator(mediator: FilmByIdMediatorImpl): FilmByIdMediator

    @Binds
    @IntoMap
    @MediatorsQualifier
    @ClassKey(FilmByIdMediator::class)
    fun bindFilmByIdMediator(mediator: FilmByIdMediator): Any
}