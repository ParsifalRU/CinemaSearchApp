package dev.ivan_belyaev.all_films_api.di

import dagger.Component
import dev.ivan_belyaev.all_films_api.presentation.fragment.AllFilmsFragment
import dev.ivan_belyaev.core.app.ApplicationProvider

@Component(
    modules = [
        AllFilmsViewModelsModule::class,
        AllFilmsApiModule::class,
        AllFilmsMediatorsModule::class,
        AllFilmsRepositoryModule::class
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)

interface AllFilmsComponent {

    companion object {

        fun init(applicationProvider: ApplicationProvider): AllFilmsComponent {
            return DaggerAllFilmsComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(applicationProvider: ApplicationProvider): AllFilmsComponent
    }

    fun inject(fragment: AllFilmsFragment)
}