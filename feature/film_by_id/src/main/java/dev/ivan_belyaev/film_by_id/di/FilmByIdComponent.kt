package dev.ivan_belyaev.film_by_id.di

import dagger.Component
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.film_by_id.presentation.fragment.FilmByIdFragment

@Component(
    modules = [
        FilmByIdViewModelsModule::class,
        FilmByIdApiModule::class,
        FilmByIdMediatorsModule::class,
        FilmByIdMediatorsModule::class,
        FilmByIdRepositoryModule::class,
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)

interface FilmByIdComponent {

    companion object {

        fun init(applicationProvider: ApplicationProvider): FilmByIdComponent {
            return DaggerFilmByIdComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(applicationProvider: ApplicationProvider): FilmByIdComponent
    }

    fun inject(fragment: FilmByIdFragment)
}