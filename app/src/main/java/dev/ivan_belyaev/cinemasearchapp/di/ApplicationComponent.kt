package dev.ivan_belyaev.cinemasearchapp.di

import dagger.Component
import dev.ivan_belyaev.cinemasearchapp.app.CinemaSearchApplication
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.app.CoreDependenciesProvider
import dev.ivan_belyaev.core.base.di.ViewModelFactoryModule
import dev.ivan_belyaev.core_factory.CoreFactory
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependenciesProvider::class,
    ],
    modules = [
        ViewModelFactoryModule::class,
    ]
)
internal interface ApplicationComponent : ApplicationProvider {

    companion object {
        fun init(app: CinemaSearchApplication): ApplicationProvider {
            val androidDependenciesProvider = CoreFactory.createCoreDependenciesProvider(app)
            return DaggerApplicationComponent.factory()
                .create(
                    coreDependenciesProvider = androidDependenciesProvider,
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            coreDependenciesProvider: CoreDependenciesProvider,
        ): ApplicationComponent
    }

    fun inject(app: CinemaSearchApplication)
}