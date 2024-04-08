package dev.ivan_belyaev.all_films_api.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.all_films_api.AllFilmsMediator
import dev.ivan_belyaev.all_films_api.api.AllFilmsMediatorImpl

@Module
interface AllFilmsMediatorModule {

    @Binds
    fun bindMediator(mediator: AllFilmsMediatorImpl): AllFilmsMediator

    @Binds
    @IntoMap
    @ClassKey(AllFilmsMediator::class)
    fun bindMediatorToMap(mediator: AllFilmsMediator): Any
}