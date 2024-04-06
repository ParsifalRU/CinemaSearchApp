package dev.ivan_belyaev.cinemasearchapp.di

import dagger.Component
import dev.ivan_belyaev.cinemasearchapp.app.CinemaSearchApplication
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.app.CoreDependenciesProvider
import dev.ivan_belyaev.core.base.di.ViewModelFactoryModule
import dev.ivan_belyaev.core.network.NetworkProvider
import dev.ivan_belyaev.core_factory.CoreFactory
import dev.ivan_belyaev.network.di.NetworkComponent
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependenciesProvider::class,
        NetworkProvider::class
    ],
    modules = [
        ViewModelFactoryModule::class,
        ScreensBinding::class,
    ]
)
internal interface ApplicationComponent : ApplicationProvider {

    companion object {
        fun init(app: CinemaSearchApplication): ApplicationProvider {
            val androidDependenciesProvider = CoreFactory.createCoreDependenciesProvider(app)
            return DaggerApplicationComponent.factory()
                .create(
                    coreDependenciesProvider = androidDependenciesProvider,
                    networkProvider = NetworkComponent.init(androidDependenciesProvider),
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            coreDependenciesProvider: CoreDependenciesProvider,
            networkProvider: NetworkProvider,
        ): ApplicationComponent
    }

    fun inject(app: CinemaSearchApplication)
}