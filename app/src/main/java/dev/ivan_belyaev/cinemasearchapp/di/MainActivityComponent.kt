package dev.ivan_belyaev.cinemasearchapp.di

import dagger.Component
import dev.ivan_belyaev.cinemasearchapp.MainActivity
import dev.ivan_belyaev.core.app.ApplicationProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ApplicationProvider::class,
    ],
    modules = [
        ScreensBinding::class,
        MainActivityViewModelsModule::class,
    ]
)
internal interface MainActivityComponent {

    companion object {

        fun init(applicationProvider: ApplicationProvider): MainActivityComponent {
            return DaggerMainActivityComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}