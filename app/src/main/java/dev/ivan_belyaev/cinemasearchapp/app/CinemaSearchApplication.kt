package dev.ivan_belyaev.cinemasearchapp.app

import android.app.Application
import dev.ivan_belyaev.cinemasearchapp.di.ApplicationComponent
import dev.ivan_belyaev.core.app.App
import dev.ivan_belyaev.core.app.ApplicationProvider

internal class CinemaSearchApplication : Application(), App {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }
}