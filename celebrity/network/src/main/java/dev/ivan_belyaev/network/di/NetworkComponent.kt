package dev.ivan_belyaev.network.di

import dagger.Component
import dev.ivan_belyaev.core.app.AndroidDependenciesProvider
import dev.ivan_belyaev.core.network.NetworkProvider

@Component(
    dependencies = [
        AndroidDependenciesProvider::class
    ],
    modules = [
        NetworkModule::class
    ]
)
interface NetworkComponent : NetworkProvider {

    companion object {

        fun init(
            androidDependenciesProvider: AndroidDependenciesProvider
        ): NetworkProvider {
            return DaggerNetworkComponent.factory()
                .create(androidDependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            androidDependenciesProvider: AndroidDependenciesProvider
        ): NetworkProvider
    }
}