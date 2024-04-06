package dev.ivan_belyaev.core_impl.di.android

import android.app.Application
import dagger.Component
import dev.ivan_belyaev.core.app.CoreDependenciesProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidDependenciesModule::class,
        CoreDependenciesModule::class,
    ]
)

interface CoreDependenciesComponent : CoreDependenciesProvider {

    fun inject(application: Application)

    companion object {
        fun create(app: Application): CoreDependenciesProvider {

            return DaggerCoreDependenciesComponent.builder()
                .androidDependenciesModule(AndroidDependenciesModule(app))
                .build()
        }
    }
}