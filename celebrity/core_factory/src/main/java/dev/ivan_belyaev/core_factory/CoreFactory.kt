package dev.ivan_belyaev.core_factory

import android.app.Application
import dev.ivan_belyaev.core.app.CoreDependenciesProvider
import dev.ivan_belyaev.core_implementation.di.android.CoreDependenciesComponent

object CoreFactory {

    fun createCoreDependenciesProvider(app: Application): CoreDependenciesProvider {

        return CoreDependenciesComponent.create(app)
    }
}