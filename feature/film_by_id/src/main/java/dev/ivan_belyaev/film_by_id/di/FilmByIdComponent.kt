package dev.ivan_belyaev.film_by_id.di

import dagger.BindsInstance
import dagger.Component
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.film_by_id.presentation.FilmByIdFragment
import dev.ivan_belyaev.film_by_id_api.FilmByIdApiModel

@Component(
    modules = [
        FilmByIdViewModelsModule::class,
        FilmByIdApiModule::class,
        FilmByIdRepositoryModule::class,
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)

interface FilmByIdComponent {

    companion object {

        fun init(applicationProvider: ApplicationProvider, filmByIdApiModel: FilmByIdApiModel): FilmByIdComponent {
            return DaggerFilmByIdComponent.factory()
                .create(applicationProvider, filmByIdApiModel)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance filmByIdApiModel: FilmByIdApiModel

        ): FilmByIdComponent
    }

    fun inject(fragment: FilmByIdFragment)
}